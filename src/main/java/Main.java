import java.util.Scanner;

public class Main extends Users {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать");
        System.out.println("Что будем делать?");
        System.out.println("1. Авторизоваться");
        System.out.println("2. Регистрироваться");
        int choice = scanner.nextInt();
        switch (choice) {
            case (1): {
                System.out.println("Введите логин");
                String login = scanner.next();
                System.out.println("Введите пароль");
                String password = scanner.next();
                checkUser(login, password);
                break;
            }
            case (2): {
                System.out.println("Введите логин");
                String login = scanner.next();
                System.out.println("Введите пароль");
                String password = scanner.next();
                createrUser(login, password);
                break;
            }
        }
    }
}
