import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface Budget {
    public HashMap<String, Integer> budget = new HashMap<String, Integer>();
    public void setBudget(String budgetName, int budgetValue);
}
