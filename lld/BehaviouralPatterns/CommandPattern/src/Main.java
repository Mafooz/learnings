public class Main {
    public static void main(String[] args) {

        AC ac = new AC();
        // here even if the logic changes for switching on/off AC, this command will still work
        // it is kind of like a remote
        TurnACOffCommand turnACOffCommand = new TurnACOffCommand(ac);
        turnACOffCommand.execute();
        TurnACOnCommand turnACOnCommand = new TurnACOnCommand(ac);
        turnACOnCommand.execute();
    }
}
