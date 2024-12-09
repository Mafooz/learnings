public class TurnACOnCommand implements ICommand{

    AC ac;

    public TurnACOnCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
//        this logic only changes if there is a change in a command.
        ac.turnOffAC();
    }
}
