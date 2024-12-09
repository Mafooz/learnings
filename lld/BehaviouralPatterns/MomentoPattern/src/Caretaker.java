import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Caretaker {

    Stack<Momento> momentoList;

    Originator originator;

    public Caretaker(Originator originator) {
        momentoList = new Stack<>();
        this.originator = originator;
    }

    public void createMomento() {
        momentoList.push(originator.save());
    }

    public void undoLast() {
        originator.restore(momentoList.pop());
    }
}
