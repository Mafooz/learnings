import java.util.ArrayList;
import java.util.List;


public class Publisher implements IPublisher{

    private String state;
    private List<IObserver> observerList;

    public Publisher() {
        state="Start State";
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(IObserver observer) {
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }

    @Override
    public void deleteObserver(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void publishChange(String changedValue) {
        state = changedValue;
        for(IObserver observer: observerList) {
            observer.setLatestValue();
        }
    }

    public String getLatestState() {
        return state;
    }
}

