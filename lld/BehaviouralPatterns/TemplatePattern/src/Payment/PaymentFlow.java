package Payment;

public abstract class PaymentFlow {

    public final void sendMoney() {
        validateRequest();
        debitAmount();
        calculateFees();
        creditAmount();
    }

    abstract void validateRequest();

    abstract void debitAmount();

    abstract void calculateFees();

    abstract void creditAmount();
}
