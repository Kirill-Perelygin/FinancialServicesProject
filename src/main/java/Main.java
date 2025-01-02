import java.util.Scanner;

public class Main extends Users {

    public static boolean isAuthorised;
    public static boolean isLoggedIn;
    public static boolean isAddingOver;
    public static int firstMenuChoice;
    public static int choiceWhenLogged;
    public static int choiceToRepeatInformationAdding;
    public static String login;
    public static String password;
    public static String incomeName;
    public static Integer incomeValue;
    public static String expenseName;
    public static Integer expenseValue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Wallet wallet = new Wallet();
        System.out.println("Добро пожаловать");
        isAuthorised = false;
        while (!isAuthorised) {
            System.out.println("Что будем делать?");
            System.out.println("1. Авторизоваться");
            System.out.println("2. Регистрироваться");
            firstMenuChoice = scanner.nextInt();
            switch (firstMenuChoice) {
                case (1): {
                    System.out.println("Введите логин");
                    login = scanner.next();
                    System.out.println("Введите пароль");
                    password = scanner.next();
                    if (checkUser(login, password)) {
                        System.out.println("Привет, " + login + "!. Что будем делать?");
                        isLoggedIn = true;
                        isAddingOver = true;
                        while (isAddingOver) {
                            System.out.println("1. Добавить доходы");
                            System.out.println("2. Добавить расходы");
                            System.out.println("3. Установить бюджет");
                            System.out.println("4. Вернуться назад");
                            choiceWhenLogged = scanner.nextInt();
                            switch (choiceWhenLogged) {
                                case (1): {
                                    System.out.println("Введите категорию дохода");
                                    incomeName = scanner.next();
                                    System.out.println("Введите сумму дохода");
                                    incomeValue = scanner.nextInt();
                                    wallet.addIncome(login, incomeName, incomeValue);
                                    isAddingOver = false;
                                    break;
                                }
                                case (4): {
                                    isLoggedIn = false;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
                case (2): {
                    System.out.println("Введите логин");
                    login = scanner.next();
                    System.out.println("Введите пароль");
                    password = scanner.next();
                    createrUser(login, password);
                    break;
                }
            }
        }
    }
}