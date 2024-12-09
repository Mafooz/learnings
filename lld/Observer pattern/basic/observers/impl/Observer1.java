package observers.impl;

import observables.IObservable;
import observers.IObserver;

public class Observer1 implements IObserver {

    private IObservable observable;

    private String status;

    public Observer1(IObservable observable) {
        this.observable = observable;
    }

    @Override
    public void printStatus() {
        System.out.println("Observable1 status is: " + this.status);
    }

    @Override
    public void updateStatus() {
        this.status = observable.getStatus();
    }
}
