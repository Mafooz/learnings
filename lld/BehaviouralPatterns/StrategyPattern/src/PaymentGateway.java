public class PaymentGateway {

    int amountToPay;
    IPayment paymentType;

    public PaymentGateway(int amountToPay, IPayment paymentType) {
        this.amountToPay = amountToPay;
        this.paymentType = paymentType;
    }

    public void pay() {
        paymentType.makePayment(amountToPay);
    }
}
