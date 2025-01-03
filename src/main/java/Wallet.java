import java.util.*;

public class Wallet implements Income, Expenses, Budget {
    public static String incomeBoundary;

    public static LinkedHashMap<String, LinkedHashMap<String, Integer>> wallet = new LinkedHashMap<>();

    public void getTotalIncome() {
        int totalSum = income.values().stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Сумма всех доходов равняется: " + totalSum);

        for (Map.Entry<String, List<Integer>> entry : income.entrySet()) {
            String key = entry.getKey();
            List<Integer> value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }


    public void getTotalExpenses(){
        int totalSum2 = expenses.values().stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Сумма всех расходов равняется: " + totalSum2);

        for (Map.Entry<String, List<Integer>> entry2 : expenses.entrySet()) {
            String key2 = entry2.getKey();
            List<Integer> value2 = entry2.getValue();
            System.out.println(key2 + ": " + value2);
        }
    }


    public void showIncomeByCategories(String login, Integer value) {
    }

    public void addIncome(String incomeName, Integer incomeValue) {
        if (incomeValue < 0) {
            System.out.println("Сумма не может быть меньше нуля.");
        } else {
            if (!income.containsKey(incomeName)) {
                income.put(incomeName, new ArrayList<>(Collections.singletonList(incomeValue)));
            } else {
                income.get(incomeName).add(incomeValue);
            }
        }
    }
    public void addExpenses(String expenseName, int expenseValue) {
        if (expenseValue < 0) {
            System.out.println("Сумма не может быть меньше нуля.");
        } else {
            if (!expenses.containsKey(expenseName)) {
                expenses.put(expenseName, new ArrayList<>(Collections.singletonList(expenseValue)));
            } else {
                expenses.get(expenseName).add(expenseValue);
            }
        }
    }

    public void setBudget(){

    }

    public static void main(String[] args) {

    }


}
