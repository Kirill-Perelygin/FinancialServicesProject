import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Wallet implements Income, Expenses, Budget {
    public static String incomeBoundary;

    public static LinkedHashMap<String, LinkedHashMap<String, Integer>> wallet = new LinkedHashMap<>();

    public void getTotalIncome() {

    }
    public void showIncomeByCategories(String login, Integer value) {
    }

    public void addIncome(String login, String incomeName, Integer incomeValue) {
        if ((incomeValue < 0)) {
            System.out.println("Сумма не может быть больше нуля или словом");
        }
        else {
            income.put(incomeName, Collections.singletonList(incomeValue));
            System.out.println("Доходы добавлены");
        }

    }
    public void addExpenses(String expenseName, int expenseValue) {

    }

    public void setBudget(){

    }

    public static void main(String[] args) {

    }


}
