import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public interface Income {
    public LinkedHashMap<String, List<Integer>> income = new LinkedHashMap<>();
    void getTotalIncome();
    void showIncomeByCategories(String key, Integer value);
    void addIncome(String login, String incomeName, Integer incomeValue);
}
