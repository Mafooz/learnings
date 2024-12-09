import java.util.Map;

public class Request {

    private String operation;

    private String key;

    private Map<String, Object> value;

    private String attribute;

    public Request(String operation, String key, Map<String, Object> value, String attribute) {
        this.operation = operation;
        this.key = key;
        this.value = value;
        this.attribute = attribute;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, Object> getValue() {
        return value;
    }

    public void setValue(Map<String, Object> value) {
        this.value = value;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
