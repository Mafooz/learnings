import models.*;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        SplitwiseApp splitwiseApp = new SplitwiseApp();

        // create user
        User user1 = splitwiseApp.getUserController().createUser("Mahfooz", "mahfooz@gmail.com", "8011990817");
        User user2 = splitwiseApp.getUserController().createUser("Aman", "aman@gmail.com", "1234567890");
        User user3 = splitwiseApp.getUserController().createUser("Rishi", "rishi@gmail.com", "2012808021");

        System.out.println("Created expense with id " + splitwiseApp.createExpense("500.00 0 2 1 2 EQUAL"));
        splitwiseApp.createExpense("1200.00 1 2 0 2 EXACT 300.00 500.00 400.00");
        splitwiseApp.createExpense("700.00 2 3 0 1 2 PERCENTAGE 50 30 20");

        //create expense
        splitwiseApp.show(1);

        splitwiseApp.showAll();
    }
}
