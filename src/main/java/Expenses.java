import java.util.LinkedHashMap;
import java.util.List;

public interface Expenses {
    public LinkedHashMap<String, List<Integer>> expenses = new LinkedHashMap<>();

    void addExpenses(String expenseName, int expenseValue);
}
