public class Rule {
    private int time;
    private String field;
    private String value;

    public Rule(int time, String field, String value) {
        this.time = time;
        this.field = field;
        this.value = value;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
