package Payment;

public class CreditCardPayment extends PaymentFlow{

    @Override
     void validateRequest() {
        System.out.println("Validating Credit card payment");
    }

    @Override
    void calculateFees() {
        System.out.println("Calculating Credit card fees");
    }

    @Override
    void creditAmount() {
        System.out.println("Crediting 100 via credit card");
    }

    @Override
    void debitAmount() {
        System.out.println("Debiting 100 via credit card");
    }
}
