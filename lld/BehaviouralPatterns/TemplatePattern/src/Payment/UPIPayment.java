package Payment;

public class UPIPayment extends PaymentFlow{

    @Override
    public void validateRequest() {
        System.out.println("Validating UPI payment");
    }

    @Override
    public void calculateFees() {
        System.out.println("Calculating UPI fees");
    }

    @Override
    public void creditAmount() {
        System.out.println("Crediting 100 via UPI");
    }

    @Override
    public void debitAmount() {
        System.out.println("Debiting 100 via UPI");
    }
}
