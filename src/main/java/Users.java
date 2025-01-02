import java.util.HashMap;
import java.util.LinkedHashMap;

public class Users {
    static Wallet wallet = new Wallet();
    public static HashMap<String, String> users = new HashMap<>();

    public static void createrUser(String login, String password) {
        if (users.containsKey(login)){
            System.out.println("Такой пользователь уже существует, придумайте себе другой логин");
        }
        else {
            users.put(login, password);
            System.out.println("Пользователь создан");
        }
    }

    public static boolean checkUser(String login, String password) {
       if (users.containsKey(login) && users.containsValue(password)) {
           System.out.println("Добро пожаловать");
       return true;
       }
       else {
           System.out.println("Такого пользователя не знаем");
           return false;
       }
    }

    public static void main(String[] args) {


    }
}