public class Main {

    public static void main(String[] args) {

        MerchantPayments merchantPayments = new MerchantPayments();

        merchantPayments.acceptRequests(5,"R1",5.60,"4242424242424242","bobs_burgers");
        merchantPayments.acceptRequests(10,"R2",500.00,"4242111111111111","a_corp");


        FradulentRules fradulentRules = new FradulentRules();

        fradulentRules.addRules(1, "merchant", "bobs_burgers");
//        fradulentRules.addRules(5, "amount", "5.60");
//        fradulentRules.addRules(9, "unique_id", "R2");
        fradulentRules.addRules(20, "cardNumber", "4242111111111111");



        merchantPayments.generateReceipts(fradulentRules);

        System.out.println("Get total loss amount : " + merchantPayments.getTotalLoss(fradulentRules));
    }
}
