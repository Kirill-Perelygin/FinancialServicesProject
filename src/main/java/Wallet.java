import java.util.*;

public class Wallet implements Income, Expenses, Budget {
    public static String incomeBoundary;

    public static LinkedHashMap<String, LinkedHashMap<String, Integer>> wallet = new LinkedHashMap<>();

    public void getTotalIncome() {

    }
    public void showIncomeByCategories(String login, Integer value) {
    }

    public void addIncome(String login, String incomeName, Integer incomeValue) {
        if (incomeValue < 0) {
            System.out.println("Сумма не может быть меньше нуля.");
        } else {
            // Проверяем, есть ли уже список под ключом incomeName
            if (!income.containsKey(incomeName)) {
                // Если списка еще нет, создаем новый и добавляем туда incomeValue
                income.put(incomeName, new ArrayList<>(Collections.singletonList(incomeValue)));
            } else {
                // Если список уже существует, просто добавляем новое значение в существующий список
                income.get(incomeName).add(incomeValue);
            }

            for (Map.Entry<String, List<Integer>> entry : income.entrySet()) {
                String key = entry.getKey();
                List<Integer> value = entry.getValue();
                System.out.println(key + ": " + value);
                //  for (Map.Entry<String, List<Integer>> entry : income.entrySet()) {
                //        System.out.println("Ключ: " + entry.getKey() + ", Значение: " + entry.getValue());
                //   }
            }

        }
    }
    public void addExpenses(String expenseName, int expenseValue) {

    }

    public void setBudget(){

    }

    public static void main(String[] args) {

    }


}
