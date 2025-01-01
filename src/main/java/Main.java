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
        while (true) {
            System.out.println("Добро пожаловать");
            isAuthorised = true;
            while (isAuthorised) {
                System.out.println("Что будем делать?");
                System.out.println("1. Авторизоваться");
                System.out.println("2. Регистрироваться");
                System.out.println("3. Вернуться на главную");
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
                            System.out.println("1. Добавить доходы");
                            System.out.println("2. Добавить расходы");
                            System.out.println("3. Установить бюджет");
                            System.out.println("4. Вернуться назад");
                            choiceWhenLogged = scanner.nextInt();
                            switch (choiceWhenLogged){
                                case(1): {
                                    isAddingOver = true;
                                    while (isAddingOver) {
                                        System.out.println("Введите категорию дохода");
                                        incomeName = scanner.next();
                                        System.out.println("Введите сумму дохода");
                                        incomeValue = scanner.nextInt();
                                        wallet.addIncome(incomeName, incomeValue);

                                        break;
                                    }
                                }
                                case(2): {
                                    isAddingOver = true;
                                    while(isAddingOver){
                                    System.out.println("Введите категорию расходов");
                                    expenseName = scanner.next();
                                    System.out.println("Введите сумму расходов");
                                    expenseValue = scanner.nextInt();
                                    wallet.addExpenses(expenseName, expenseValue);
                                    System.out.println("Добавить еще?");
                                    System.out.println("1. Да");
                                    System.out.println("2. Нет");
                                    choiceToRepeatInformationAdding = scanner.nextInt();
                                    switch (choiceToRepeatInformationAdding) {
                                        case (1): {
                                            break;
                                        }
                                        case (2): {
                                            isAddingOver = false;
                                        }
                                        default: {

                                        }
                                    }
                                    }
                                    break;
                                }
                                case(3): {
                                    isAddingOver = true;

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
                        login = scanner.next();
                        System.out.println("Введите пароль");
                        password = scanner.next();
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