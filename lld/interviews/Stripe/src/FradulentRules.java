import java.util.ArrayList;
import java.util.List;

public class FradulentRules {

    List <Rule> fradulentRules;

    public FradulentRules() {
        fradulentRules = new ArrayList<>();
    }

    public void addRules(int time, String fieldName, String fieldValue) {
        fradulentRules.add(new Rule(time, fieldName, fieldValue));
    }

    public List<Rule> getAllRules() {
        return fradulentRules;
    }
}
