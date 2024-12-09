import Payment.CreditCardPayment;
import Payment.PaymentFlow;
import Payment.UPIPayment;

public class Main {
    public static void main(String[] args) {
        PaymentFlow paymentFlow = new UPIPayment();
        paymentFlow.sendMoney();
        paymentFlow = new CreditCardPayment();
        paymentFlow.sendMoney();
    }
}
