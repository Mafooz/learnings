package models;

import java.util.Map;

public class Expense {

    private ExpenseType expenseType;
    private double amount;
    private User paidBy;
    Map<User, Double> paidTo;

    Expense(double total, ExpenseType expenseType, User paidBy, Map<User, Double> paidTo) {
        this.amount = total;
        this.expenseType = expenseType;
        this.paidBy = paidBy;
        this.paidTo = paidTo;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public Map<User, Double> getPaidTo() {
        return paidTo;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public void setPaidTo(Map<User, Double> paidTo) {
        this.paidTo = paidTo;
    }
}
