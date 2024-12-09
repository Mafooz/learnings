package observers.impl;

import observables.IObservable;
import observers.IObserver;

public class Observer2 implements IObserver {

    private IObservable observable;

    private String status;

    public Observer2(IObservable observable) {
        this.observable = observable;
    }

    public Observer2() {
        status = "";
    }
    @Override
    public void printStatus() {
        System.out.println("Observer 2 status is: " + this.status);
    }

    @Override
    public void updateStatus() {
        this.status = observable.getStatus();
    }
}
