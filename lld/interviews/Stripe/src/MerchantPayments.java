import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MerchantPayments {

    List<PaymentRequest> paymentRequestsList;

    public MerchantPayments() {
        paymentRequestsList = new ArrayList<>();
    }
    public void acceptRequests(int timestamp, String unique_id, Double amount, String cardNumber, String merchant) {
        PaymentRequest paymentRequest = new PaymentRequest(timestamp, unique_id, amount, cardNumber, merchant);
        paymentRequestsList.add(paymentRequest);
    }

    public void generateReceipts(FradulentRules fradulentRules) {
        Collections.sort(paymentRequestsList);
        for(PaymentRequest paymentRequest: paymentRequestsList) {
            System.out.println(paymentRequest.getTimestamp() + " " + paymentRequest.getUnique_id() + " " + paymentRequest.getAmount() + " " + getApprovalStatus(paymentRequest, fradulentRules));
        }
    }

    public String getApprovalStatus(PaymentRequest paymentRequest, FradulentRules fradulentRules) {
        for(Rule rule: fradulentRules.getAllRules()) {
            if (!isAuthorised(rule, paymentRequest)) {
                return "REJECT";
            }
        }
        return "APPROVE";
    }

    public String getApprovalStatusDaily(PaymentRequest paymentRequest, FradulentRules fradulentRules) {
        for(Rule rule: fradulentRules.getAllRules()) {
            if (!isAuthorisedDaily(rule, paymentRequest)) {
                return "REJECT";
            }
        }
        return "APPROVE";
    }
    private boolean isAuthorised(Rule rule, PaymentRequest paymentRequest) {
        if (rule.getTime() > paymentRequest.getTimestamp()) {
            return true;
        }
        if (rule.getField().equals("unique_id")) {
            if (rule.getValue().equals(paymentRequest.getUnique_id())) {
                return false;
            }
        }
        if (rule.getField().equals("cardNumber")) {
            if (rule.getValue().equals(paymentRequest.getCardNumber())) {
                return false;
            }
        }
        if (rule.getField().equals("amount")) {
            Double ruleValue = Double.valueOf(rule.getValue());
            if (ruleValue.equals(paymentRequest.getAmount())) {
                return false;
            }
        }
        if (rule.getField().equals("merchant")) {
            if (rule.getValue().equals(paymentRequest.getMerchant())) {
                return false;
            }
        }
        return true;
    }


    private boolean isAuthorisedDaily(Rule rule, PaymentRequest paymentRequest) {
        if (rule.getField().equals("unique_id")) {
            if (rule.getValue().equals(paymentRequest.getUnique_id())) {
                return false;
            }
        }
        if (rule.getField().equals("cardNumber")) {
            if (rule.getValue().equals(paymentRequest.getCardNumber())) {
                return false;
            }
        }
        if (rule.getField().equals("amount")) {
            Double ruleValue = Double.valueOf(rule.getValue());
            if (ruleValue.equals(paymentRequest.getAmount())) {
                return false;
            }
        }
        if (rule.getField().equals("merchant")) {
            if (rule.getValue().equals(paymentRequest.getMerchant())) {
                return false;
            }
        }
        return true;
    }

    public Double getTotalLoss(FradulentRules fradulentRules) {
        Double totalLoss=0.0;
        for(PaymentRequest paymentRequest: paymentRequestsList) {
            if (getApprovalStatusDaily(paymentRequest, fradulentRules).equals("REJECT") && getApprovalStatus(paymentRequest, fradulentRules).equals("APPROVE"))
                totalLoss = totalLoss + paymentRequest.getAmount();
        }
        return totalLoss;
    }
}
