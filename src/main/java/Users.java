import java.util.HashMap;

public class Users {

    public static HashMap<String, String> users = new HashMap<>();

    public static void createrUser(String login, String password) {
        users.put(login,password);
        System.out.println("Пользователь создан");
    }

    public static void checkUser(String login, String password) {
       if (users.containsKey(login) && users.containsValue(password)) {
           System.out.println("Добро пожаловать");
       }
       else {
           System.out.println("Такого пользователя не знаем");
       }
    }

    public static void main(String[] args) {


    }
}