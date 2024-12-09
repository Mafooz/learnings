public class VendingMachine {

    private VendingMachineState vendingMachineState;

    public VendingMachine() {
        vendingMachineState = new IdleState();
    }
    public void setVendingMachineState(String state) {
        switch (state) {
            case "Idle":
                vendingMachineState = new IdleState();
                break;
            case "Dispense":
                vendingMachineState = new DispenseState();
                break;
        }
    }
    public String getItem() {
        return "This is dispensed!!";
    }

    public VendingMachineState getCurrentState() {
        return vendingMachineState;
    }
}
