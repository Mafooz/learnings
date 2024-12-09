package model;

import java.util.HashMap;
import java.util.Map;

public class MerchantList {
    private static final Map<String, Merchant> merchantList = new HashMap<>();

    public static Merchant addMerchantIfNotPresent(String merchId) {
        Merchant merchant = getMerchant(merchId);
        if (merchant == null) {
            merchant = new Merchant(merchId);
            merchantList.put(merchId, merchant);
        }
        return merchant;
    }

    public static Merchant getMerchant(String merchId) {
        return merchantList.get(merchId);
    }

    public static void removeMerchant(String merchId) {
        merchantList.remove(merchId);
    }
    public static void printAll() {
        for(Merchant merchant: MerchantList.merchantList.values()) {
            System.out.println(merchant.getMerchId() + ", " + merchant.getTotalLoanAmount());
        }
    }
}
