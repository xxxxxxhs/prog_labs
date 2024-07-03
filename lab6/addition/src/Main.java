import Exceptions.IncorrectValueException;

public class Main {
    public static void main(String[] args) {
        Act act = new Act();
        try {
            act.deserialize();
        } catch (IncorrectValueException e) {
            throw new RuntimeException(e);
        }
    }
}