public class Main {
    public static void main(String[] args) {
        PaymentGateway paymentGateway = new PaymentGateway(200, new CardPayment());
        paymentGateway.pay();
        paymentGateway = new PaymentGateway(500, new CashPayment());
        paymentGateway.pay();
        paymentGateway = new PaymentGateway(1000, new UPIPayment());
        paymentGateway.pay();
    }
}
