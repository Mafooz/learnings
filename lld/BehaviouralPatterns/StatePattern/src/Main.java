public class Main {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        System.out.println(vendingMachine.getCurrentState().getClass().getName());

        vendingMachine.getCurrentState().dispenseItem(vendingMachine);
        vendingMachine.getCurrentState().insertCoin(vendingMachine);
        vendingMachine.getCurrentState().insertCoin(vendingMachine);
        System.out.println(vendingMachine.getCurrentState().getClass().getName());
        vendingMachine.getCurrentState().dispenseItem(vendingMachine);
        vendingMachine.getCurrentState().dispenseItem(vendingMachine);
    }
}
