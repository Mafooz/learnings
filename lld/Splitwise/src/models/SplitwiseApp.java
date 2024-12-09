package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitwiseApp {

    UserController userController;
    ExpenseController expenseController;
    public SplitwiseApp() {
        userController = new UserController();
        expenseController = new ExpenseController();
    }

    public UserController getUserController() {
        return userController;
    }

    public String createExpense(String expenseString) {
        String[] expense = expenseString.split(" ");
        double amount = Double.parseDouble(expense[0]);
        User paidBy = userController.getAllUsers().get(Integer.parseInt(expense[1]));
        Map<User, Double> paidTo = new HashMap<>();
        int totalPaidTo = Integer.parseInt(expense[2]);
        ExpenseType expenseType = ExpenseType.valueOf(expense[3+totalPaidTo]);
        for(int i=3;i<3+totalPaidTo;i++) {
            User user = userController.getAllUsers().get(Integer.parseInt(expense[i]));
            double val;
            switch (expenseType) {
                case ExpenseType.EQUAL -> {
                    val = totalPaidTo;
                }
                case EXACT, PERCENTAGE -> {
                    val = Double.parseDouble(expense[i +1+ totalPaidTo]);
                }
                default -> {
                    val = 0.0;
                }
            }
            paidTo.put(user, val);
        }
        return expenseController.createExpense(amount, expenseType, paidBy, paidTo);
    }

    public void show(int userId) {
        userController.getAllUsers().get(userId).showBalance();
    }
    public void showAll() {
        userController.showAllBalances();
    }
}
