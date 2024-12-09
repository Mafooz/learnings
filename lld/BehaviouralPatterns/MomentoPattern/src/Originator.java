public class Originator {

    public int value;
    public String name;

    public Originator() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Momento save() {
        return new Momento(value, name);
    }

    public void restore(Momento momento) {
        name = momento.name;
        value = momento.value;
    }
}
