import model.Merchant;
import model.MerchantList;
import model.Request;

public class Executor {

    public static boolean executeCreateLoan(Request request) {
        Merchant merchant = MerchantList.addMerchantIfNotPresent(request.getInputParams().getFirst());
        String loanId = request.getInputParams().get(1);
        Integer amount = Integer.valueOf(request.getInputParams().get(2));
        return merchant.addLoan(loanId, amount);
    }
    public static boolean executePayLoan(Request request) {
        Merchant merchant = MerchantList.getMerchant(request.getInputParams().getFirst());
        if (merchant==null) {
            System.out.println("No existing Merchant");
            return false;
        }
        String merchId = request.getInputParams().getFirst();
        if (!merchant.getMerchId().equals(merchId)) {
            return false;
        }
        String loanId = request.getInputParams().get(1);
        Integer amount = Integer.valueOf(request.getInputParams().get(2));
        return merchant.payOffLoan(loanId, amount);
    }
    public static boolean executeIncreaseLoan(Request request) {
        Merchant merchant = MerchantList.getMerchant(request.getInputParams().getFirst());
        if (merchant==null) {
            System.out.println("No existing Merchant");
            return false;
        }
        String loanId = request.getInputParams().get(1);
        Integer amount = Integer.valueOf(request.getInputParams().get(2));
        return merchant.addLoan(loanId, amount);
    }
    public static boolean transactionProcessed(Request request) {
        Merchant merchant = MerchantList.getMerchant(request.getInputParams().getFirst());
        if (merchant==null) {
            System.out.println("No existing Merchant");
            return false;
        }
        String loanId = request.getInputParams().get(1);
        Integer amount = Integer.valueOf(request.getInputParams().get(2));
        Integer percentage = Integer.valueOf(request.getInputParams().get(3));
        Integer loanToPay = (amount*percentage)/100;
        return merchant.payOffLoan(loanId, loanToPay);
    }
}
