import java.io.IOException;
import java.util.Scanner;

public class Main extends Users {

    public static boolean nonAuthorised;
    public static boolean isLoggedIn;
    public static int firstMenuChoice;
    public static int choiceWhenLogged;
    public static String login;
    public static String password;
    public static String incomeName;
    public static int incomeValue;
    public static String expenseName;
    public static int expenseValue;
    public static String budgetName;
    public static int budgetValue;

    private static void exitProgram() {
        try {
            Users.saveUsersToFile();
        } catch (IOException e) {
            System.err.println("Ошибка записи данных в файл: " + e.getMessage());
        }

        System.exit(0); // Завершаем программу
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Wallet wallet = new Wallet();

        try {
            Users.loadUsersFromFile();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка чтения данных из файла: " + e.getMessage());
        }

        nonAuthorised = true;
        System.out.println("Добро пожаловать");
        while (nonAuthorised) {
            System.out.println("Что будем делать?");
            System.out.println("1. Авторизоваться");
            System.out.println("2. Регистрироваться");
            System.out.println("3. Выйти из программы");
            firstMenuChoice = scanner.nextInt();
            switch (firstMenuChoice) {
                case (1): {
                    System.out.print("Введите логин: ");
                    login = scanner.next();
                    System.out.print("Введите пароль: ");
                    password = scanner.next();
                    if (checkUser(login, password)) {
                        isLoggedIn = true;
                        nonAuthorised = false;
                        while (isLoggedIn) {
                            System.out.println("Привет, " + login + "!. Что будем делать?");
                            System.out.println("1. Добавить доходы");
                            System.out.println("2. Добавить расходы");
                            System.out.println("3. Установить бюджет");
                            System.out.println("4. Вывести всю актуальную информацию");
                            System.out.println("5. Вернуться назад");
                            choiceWhenLogged = scanner.nextInt();
                            switch (choiceWhenLogged) {
                                case (1): {
                                    System.out.print("Введите категорию дохода: ");
                                    incomeName = scanner.next();
                                    System.out.print("Введите сумму дохода: ");
                                    incomeValue = scanner.nextInt();
                                    wallet.addIncome(incomeName, incomeValue);
                                    System.out.println();
                                    break;
                                }
                                case (2): {
                                    System.out.print("Введите категорию расходов: ");
                                    expenseName = scanner.next();
                                    System.out.print("Введите сумму расхода: ");
                                    expenseValue = scanner.nextInt();
                                    wallet.addExpenses(expenseName, expenseValue);
                                    System.out.println();
                                    break;
                                }
                                case (3): {
                                    System.out.print("Введите категорию бюджета: ");
                                    budgetName = scanner.next();
                                    System.out.println("Введите сумму бюджета: ");
                                    budgetValue = scanner.nextInt();
                                    wallet.setBudget(budgetName, budgetValue);
                                    System.out.println();
                                    break;
                                }
                                case (4): {
                                    System.out.println("Доходы");
                                    wallet.getTotalIncome();
                                    System.out.println("Расходы");
                                    wallet.getTotalExpenses();
                                    System.out.println("Бюджет");
                                    wallet.compareBudgetAndExpenses();
                                    break;
                                }
                                case (5): {
                                    isLoggedIn = false;
                                    nonAuthorised = true;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }

                case (2): {
                    System.out.print("Введите логин: ");
                    login = scanner.next();
                    System.out.print("Введите пароль: ");
                    password = scanner.next();
                    createrUser(login, password);
                    break;
                }

                case (3): {
                    exitProgram();
                    break;
                }
                default:
                    ;
            }
        }
    }

}
