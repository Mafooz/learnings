public class Necessity implements Visitee{
    private final TaxVisitor taxVisitor;
    private int price;
    private String name;

    public Necessity(int price, String name, TaxVisitor taxVisitor) {
        this.price = price;
        this.name = name;
        this.taxVisitor = taxVisitor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void calculateTax() {
        this.taxVisitor.visit(this);
    }
}
