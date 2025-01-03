import java.util.LinkedHashMap;
import java.util.List;

public interface Budget {
    public LinkedHashMap<String, List<Integer>> budget = new LinkedHashMap<>();
    public void setBudget(String budgetName, Integer budgetValue);
}
