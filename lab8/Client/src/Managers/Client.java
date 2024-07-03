package Managers;

import CollectionClasses.Movie;
import Managers.*;
import Exceptions.IncorrectValueException;
import Managers.CommandResolver;
import Managers.Console;
import Managers.Response;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.PortUnreachableException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Client {
    private DatagramChannel channel;
    private final InetSocketAddress serverAddress = new InetSocketAddress("localhost", 1488);
    private String username;
    private String hashPassword;

    public Client() throws IOException {
        this.channel = DatagramChannel.open();
        this.channel.configureBlocking(false); // Неблокирующий режим
        this.channel.connect(serverAddress); // Подключаемся к серверу
    }

    public String getUsername() {return username;}
    public String getHashPassword() {return hashPassword;}
    public boolean checkConnection() {
        try {
            sendConnection(CommandResolver.connect());
            return true;
        } catch (PortUnreachableException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private void waitForConnection(boolean start) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (start) {
            System.out.println("Сервер доступен. Можно вводить команды.");
            return;
        }
        while (true) {
            System.out.println("Сервер недоступен. Введите 'connect' для повторного подключения.");
            String input = reader.readLine();
            if (input.equals("connect") && checkConnection()) {
                System.out.println("Сервер доступен. Можно вводить команды.");
                break;
            }
        }
    }
    public void readUserCommand() throws IOException {
        waitForConnection(checkConnection()); // Ожидаем доступности сервера перед началом ввода команд
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("exit")) {
            if (!checkConnection()) {
                waitForConnection(checkConnection());
            }
            String[] args = line.split(" ");
            if (!args[0].equals("execute_script")) {
                Request request = CommandResolver.resolve(args, null, username, hashPassword);
                if (request != null && !request.getCommand().equals("connect")) send(request);
            } else {
                LinkedList<Request> requests = CommandResolver.executeScript(args[1], username, hashPassword);
                for (Request request : requests) {
                    send(request);
                }
            }
        }
    }
    private Response sendConnection(Request request) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(request);
        byte[] data = baos.toByteArray();
        ByteBuffer buffer = ByteBuffer.wrap(data);
        channel.write(buffer);
        try {
            return waitForResponse();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public Response send(Request request) throws IOException {
        if (!checkConnection()) return new Response("Connection lost");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        System.out.println("sent: " + request.getCommand());
        oos.writeObject(request);
        byte[] data = baos.toByteArray();
        ByteBuffer buffer = ByteBuffer.wrap(data);
        channel.write(buffer);
        Response response = null;
        try {
            response = waitForResponse();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
    /*
    public Response waitForResponse() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(65535);
        while (channel.read(buffer) <= 0) {
            try {
                // Небольшая задержка для уменьшения нагрузки на CPU
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Восстановление прерванного статуса
                System.err.println("Ожидание было прервано");
                return null;
            }
        }

        buffer.flip();

        try (ByteArrayInputStream bais = new ByteArrayInputStream(buffer.array());
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            Response response = (Response) ois.readObject();
            if (response.isContainCollection()) {
                System.out.println("collection size: " + response.getCollection().size());
                return response;
            }
            else if (!response.getAnswer().equals("ok")) {
                System.out.println("response: " + response.getAnswer());
                return response;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

     */
    public Response authenticateUser(String username, String password) throws NoSuchAlgorithmException {
        Request request = new Request("authorize", null, null, username, Encryptor.getHash(password));
        Response response = null;
        try {
            response = send(request);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
    public Response waitForResponse() throws IOException, ClassNotFoundException {
        Selector selector = Selector.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);

        LinkedList<Movie> allMovies = new LinkedList<>();
        boolean hasMoreResponses = true;

        while (hasMoreResponses) {
            ByteBuffer buffer = ByteBuffer.allocate(65535);
            int readyChannels = selector.select(10000); // Установка тайм-аута на 10 секунд
            if (readyChannels == 0) {
                System.out.println("Timeout reached, no data received.");
                break; // Прерываем цикл, если не получено данных
            }

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isReadable()) {
                    DatagramChannel datagramChannel = (DatagramChannel) key.channel();
                    buffer.clear();
                    int bytesRead = datagramChannel.read(buffer);
                    if (bytesRead > 0) {
                        buffer.flip();
                        try (ByteArrayInputStream bais = new ByteArrayInputStream(buffer.array(), 0, buffer.limit());
                             ObjectInputStream ois = new ObjectInputStream(bais)) {
                            Response partResponse = (Response) ois.readObject();
                            if (partResponse.isContainCollection()) {
                                allMovies.addAll(partResponse.getCollection());
                                hasMoreResponses = partResponse.hasNext();  // Проверяем, нужно ли ожидать следующую часть
                            } else {
                                hasMoreResponses = false; // Немедленно прекращаем обработку, если это не коллекция
                                return partResponse; // Возвращаем полученный ответ
                            }
                        }
                    } else {
                        System.out.println("No data was read.");
                    }
                }
                iterator.remove();
            }
        }

        return new Response(allMovies);  // Возвращаем собранный ответ с коллекцией
    }

}