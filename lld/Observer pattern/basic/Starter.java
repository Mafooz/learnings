import observables.IObservable;
import observables.Observable;
import observers.IObserver;
import observers.impl.Observer1;
import observers.impl.Observer2;

public class Starter {
    public static void main(String[] args) {
        IObservable observable = new Observable();
        IObserver observer1 = new Observer1(observable);
        IObserver observer2 = new Observer2(observable);

        observable.register(observer1);
        observable.changeState("New status");
        observer1.printStatus();
        observer2.printStatus();
        observable.register(observer2);
        observable.changeState("Second state");
        observer1.printStatus();
        observer2.printStatus();
        observable.deregister(observer1);
        observable.changeState("Third state");
        observer1.printStatus();
        observer2.printStatus();
    }
}
