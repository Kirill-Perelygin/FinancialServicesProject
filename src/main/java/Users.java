import java.io.*;
import java.util.HashMap;

public class Users implements Serializable {
    public static HashMap<String, String> users = new HashMap<>();

    public static void createrUser(String login, String password) {
        if (users.containsKey(login)) {
            System.out.println("Такой пользователь уже существует, придумайте себе другой логин");
        } else {
            users.put(login, password);
            System.out.println("Пользователь создан");
        }
    }

    public static boolean checkUser(String login, String password) {
        if (users.containsKey(login) && users.containsValue(password)) {
            System.out.println("Добро пожаловать");
            return true;
        } else {
            System.out.println("Такого пользователя не знаем");
            return false;
        }
    }

    public static void saveUsersToFile() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat"))) {
            oos.writeObject(users);
        }
    }

    public static void loadUsersFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.dat"))) {
            users = (HashMap<String, String>) ois.readObject();
        }
    }

    public static void main(String[] args) {


    }
}