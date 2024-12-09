package model;

import java.util.HashMap;
import java.util.Map;

public class Merchant {
    private final String merchId;
    Map<String, Integer> loans;
    private Integer totalLoanAmount;

    public Merchant(String merchId) {
        this.merchId = merchId;
        loans = new HashMap<>();
        totalLoanAmount=0;
    }

    public Integer getTotalLoanAmount() {
        return totalLoanAmount;
    }
    public String getMerchId(){
        return merchId;
    }

    public boolean addLoan(String loanId, Integer loanAmount) {
        loans.putIfAbsent(loanId, 0);
        loans.put(loanId, loans.get(loanId) + loanAmount);
        totalLoanAmount+=loanAmount;
        return true;
    }

    public boolean payOffLoan(String loanId, Integer loanAmount) {
        if (!loans.containsKey(loanId)) {
            System.out.println("No such loan Id");
            return false;
        }
        int finalAmount = Math.max(0,loans.get(loanId)-loanAmount);
        if (finalAmount==0) {
            totalLoanAmount-=loans.get(loanId);
            loans.remove(loanId);
        }
        else {
            totalLoanAmount-=loanAmount;
            loans.put(loanId, finalAmount);
        }
        return true;
    }
}
