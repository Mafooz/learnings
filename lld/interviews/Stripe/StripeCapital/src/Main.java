import model.Merchant;
import model.MerchantList;
import model.Request;
import utils.API;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting APIs");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while(!line.equals("done")) {
            Request request = new Request(line);
            API api = request.getApi();
            if (api == null) {
                System.out.println("Invalid API!! please try again");
                line = scanner.nextLine();
                continue;
            }
            boolean isSuccessFull = switch (api) {
                case API.CREATE_LOAN -> Executor.executeCreateLoan(request);
                case API.INCREASE_LOAN -> Executor.executeIncreaseLoan(request);
                case API.PAY_LOAN -> Executor.executePayLoan(request);
                case API.TRANSACTION_PROCESSED -> Executor.transactionProcessed(request);
                default -> {
                    System.out.println("Not implemented");
                    yield false;
                }
            };
            if (!isSuccessFull) {
                System.out.println("Error occurred!!!");
            }
            line = scanner.nextLine();
        }
        MerchantList.printAll();
    }
}
