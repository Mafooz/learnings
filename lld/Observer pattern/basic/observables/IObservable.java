package observables;

import observers.IObserver;

public interface IObservable {
    void changeState(String newState);
    String getStatus();
    void register(IObserver observer);
    void deregister(IObserver observable);
}
