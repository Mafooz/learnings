public class CashPayment implements IPayment{

    @Override
    public void makePayment(int amountToPay) {
        System.out.println("Making payment of " + amountToPay + " using Cash");
    }
}
