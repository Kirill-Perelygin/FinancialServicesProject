import java.util.Scanner;

public class Main extends Users {

    public static boolean isAuthorised;
    public static boolean isLoggedIn;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Wallet wallet = new Wallet();
        while (true) {
            System.out.println("Добро пожаловать");
            isAuthorised = true;
            while (isAuthorised) {
                System.out.println("Что будем делать?");
                System.out.println("1. Авторизоваться");
                System.out.println("2. Регистрироваться");
                System.out.println("3. Вернуться на главную");
                int choice = scanner.nextInt();
                switch (choice) {
                    case (1): {
                        System.out.println("Введите логин");
                        String login = scanner.next();
                        System.out.println("Введите пароль");
                        String password = scanner.next();
                        if (checkUser(login, password)) {
                            isLoggedIn = true;
                            System.out.println("Привет, " + login + "!. Что будем делать?");
                            System.out.println("1. Добавить доходы");
                            System.out.println("2. Добавить расходы");
                            System.out.println("3. Установить бюджет");
                            System.out.println("4. Вернуться назад");
                            int secondChoice = scanner.nextInt();
                            switch (secondChoice){
                                case(1): {
                                    break;
                                }
                                case(2): {
                                    break;
                                }
                                case(3): {
                                    break;
                                }
                                case(4): {
                                    isLoggedIn = false;
                                    System.out.println("До встречи!");
                                    break;
                                }
                                default: ;

                            }
                        } else {
                            isAuthorised = false;
                        }
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
                    case (3): {

                    }
                    default: {

                    }
                }
            }
        }
    }
}