import CollectionClasses.Movie;
import Exceptions.IncorrectValueException;
import Managers.Ask;
import Managers.Console;

import java.io.*;

public class Act {
    String fileName = "/Users/fqy/edu/prog/lab6/addition.txt";
    public Movie create() throws IncorrectValueException {
        return Ask.newMovie(new Console());
    }
    public void save(Movie movie) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(movie); // Сериализация объекта movie
            System.out.println("serialized to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deserialize() throws IncorrectValueException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("addition.txt"))) {
            Movie movie = (Movie) ois.readObject();
            System.out.println(movie.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
