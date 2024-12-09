package models;

import java.util.*;

public class ExpenseController {
    Map<String, Expense> allExpenses;

    public ExpenseController() {
        allExpenses = new HashMap<>();
    }

    public String createExpense(double total, ExpenseType expenseType, User paidBy, Map<User, Double> paidTo) {
        String id = UUID.randomUUID().toString();
        Expense expense = new Expense(total, expenseType, paidBy, paidTo);
        allExpenses.put(id, expense);
        updateDashboards(paidBy, paidTo, expense);
        return id;
    }

    private void updateDashboards(User paidBy, Map<User, Double> paidTo, Expense expense) {
        paidBy.getUserDashboard().updateOnExpense(expense);
    }
}
