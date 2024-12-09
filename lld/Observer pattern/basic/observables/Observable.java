package observables;

import observers.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Observable implements IObservable {

    String status;

    List<IObserver> listObservables;

    public Observable() {
        status=null;
        listObservables = new ArrayList<>();
    }

    @Override
    public void changeState(String newState) {
        this.status = newState;
        for (IObserver observer: listObservables) {
            observer.updateStatus();
        }
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void register(IObserver observer) {
        listObservables.add(observer);
    }

    @Override
    public void deregister(IObserver observer) {
        listObservables.remove(observer);
    }
}
