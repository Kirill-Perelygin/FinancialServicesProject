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

    public void setBudget(String budgetName, Integer budgetValue){
        if (budgetValue < 0) {
            System.out.println("Сумма не может быть меньше нуля.");
        } else {
            if (!budget.containsKey(budgetName)) {
                budget.put(budgetName, new ArrayList<>(Collections.singletonList(budgetValue)));
            } else {
                budget.get(budgetName).add(budgetValue);
            }
        }
    }
// TODO кажется бюджет считается неправильно - вместо него в категорию попадает расход, а не бюджет

    public void showBudgetDifference(String category) {
        for (Map.Entry<String, List<Integer>> entry : budget.entrySet()) {
            category = entry.getKey();
            List<Integer> values = entry.getValue();

            if (values.isEmpty()) {
                System.out.println("Для категории \"" + category + "\" нет данных.");
                continue;
            }

            int sumPerKey = 0;
            for (Map.Entry<String, List<Integer>> entry2 : expenses.entrySet()) {
                String key2 = entry.getKey();
                List<Integer> values2 = entry2.getValue();
                sumPerKey = values2.stream().mapToInt(Integer::intValue).sum();
            }

            // Предполагаем, что первый элемент списка — это бюджет
            int budget = values.get(0);
            // Суммируем все расходы, кроме первого элемента (бюджета)
            int totalExpenses = values.stream().skip(1).mapToInt(Integer::intValue).sum();
            int difference = budget - sumPerKey;
            System.out.println(category + ":" + budget + " Оставшийся бюджет: " + difference);
        }
    }

    public static void main(String[] args) {
    }
}
