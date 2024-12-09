package models;

import java.util.HashMap;
import java.util.Map;

public class UserDashboard {

    private final Map<User, Double> balances;

    public UserDashboard() {
        balances = new HashMap<>();
    }

    public void updateOnExpense(Expense expense) {
        Map<User, Double> expensePaid = expense.getPaidTo();
        for(User user: expensePaid.keySet()) {
            if (user==expense.getPaidBy()) {
                continue;
            }
            if (!balances.containsKey(user)) {
                balances.put(user, 0.0);
            }
            double getExactAmount = calcExactAmount(expensePaid.get(user), expense.getExpenseType(), expense.getAmount());
            balances.put(user, balances.get(user)+getExactAmount);
            user.getUserDashboard().updateFromPaidBy(expense.getPaidBy(), getExactAmount);
        }
    }

    public void updateFromPaidBy(User paidBy, double amount) {
        if (!balances.containsKey(paidBy)) {
            balances.put(paidBy, 0.0);
        }
        balances.put(paidBy, balances.get(paidBy)-amount);
    }

    private double calcExactAmount(Double value, ExpenseType expenseType, Double totalAmount) {
        switch (expenseType) {
            case EQUAL -> {
                return totalAmount/value;
            }
            case EXACT -> {
                return value;
            }
            case PERCENTAGE -> {
                return (totalAmount * value)/100;
            }
            default -> {
                return 0;
            }
        }
    }
    public double getTotalBalance() {
        double total = 0.0;
        for(User user: balances.keySet()) {
            total = total + balances.get(user);
        }
        return total;
    }

}
