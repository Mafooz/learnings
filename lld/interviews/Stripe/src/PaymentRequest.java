public class PaymentRequest implements Comparable{

    private int timestamp;
    private String unique_id;
    private Double amount;
    private String cardNumber;
    private String merchant;

    public PaymentRequest(int timestamp, String unique_id, Double amount, String cardNumber, String merchant) {
        this.timestamp = timestamp;
        this.unique_id = unique_id;
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.merchant = merchant;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    @Override
    public int compareTo(Object o) {
        if (this.timestamp<((PaymentRequest)o).getTimestamp()) {
            return -1;
        }
        else if (this.timestamp==((PaymentRequest)o).getTimestamp()) {
            return 0;
        }
        else return 1;
    }
}
