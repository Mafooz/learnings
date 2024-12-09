public class DispenseState implements VendingMachineState{

    @Override
    public boolean dispenseItem(VendingMachine vendingMachine) {
        System.out.println(vendingMachine.getItem());
        vendingMachine.setVendingMachineState("Idle");
        return true;
    }

    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Invalid operation!!!");
    }
}
