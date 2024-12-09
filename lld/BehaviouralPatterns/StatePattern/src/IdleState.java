public class IdleState implements VendingMachineState{

    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Coin inserted");
        vendingMachine.setVendingMachineState("Dispense");
    }

    @Override
    public boolean dispenseItem(VendingMachine vendingMachine) {
        System.out.println("Invalid operation!!!");
        return false;
    }

}
