import java.util.*;

public class Wallet implements Income, Expenses, Budget {
    public static String incomeBoundary;

    public static LinkedHashMap<String, LinkedHashMap<String, Integer>> wallet = new LinkedHashMap<>();

    public void getTotalIncome() {
        int totalSum = income.values().stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Общий доход равняется: " + totalSum);

        for (Map.Entry<String, List<Integer>> entry : income.entrySet()) {
            String key = entry.getKey();
            List<Integer> values = entry.getValue();
            int sumPerKey = values.stream().mapToInt(Integer::intValue).sum();
            System.out.println(key + ": " + sumPerKey);
        }
    }

    public void getTotalExpenses(){
        int totalSum2 = expenses.values().stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Сумма всех расходов равняется: " + totalSum2);

        for (Map.Entry<String, List<Integer>> entry : expenses.entrySet()) {
            String key = entry.getKey();
            List<Integer> values = entry.getValue();
            int sumPerKey = values.stream().mapToInt(Integer::intValue).sum();
            System.out.println(key + ": " + sumPerKey);
        }
    }

    public void addIncome(String incomeName, int incomeValue) {
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
    public void setBudget(String budgetName, int budgetValue){
        if (budgetValue < 0) {
            System.out.println("Сумма не может быть меньше нуля");
        }
        else {
            budget.put(budgetName, budgetValue);
        }
    }

    public void compareBudgetAndExpenses() {
        for (Map.Entry<String, Integer> entry : budget.entrySet()) {
            String category = entry.getKey();
            int budgetAmount = entry.getValue();
            int totalExpenses = 0;

            if (expenses.containsKey(category)) {
                for (int expense : expenses.get(category)) {
                    totalExpenses += expense;
                }
            }
            int difference = budgetAmount - totalExpenses;
            System.out.println(category + " : " + budgetAmount + ". Оставшийся бюджет: " + difference);
        }
    }

    public static void main(String[] args) {
    }
}
