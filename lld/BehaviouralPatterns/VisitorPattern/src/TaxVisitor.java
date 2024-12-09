public class TaxVisitor implements Visitor  {

    @Override
    public void visit(Liqour liqour) {
        System.out.println("Tax for " + liqour.getName() + " is " + liqour.getPrice()*0.15);
    }

    @Override
    public void visit(Necessity necessity) {
        System.out.println("Tax for " + necessity.getName() + " is " + necessity.getPrice()*0.20);
    }

    @Override
    public void visit(Food food) {
        System.out.println("Tax for " + food.getName() + " is " + food.getPrice()*0.10);
    }
}
