public class SecondObserver implements IObserver{

    private String state;
    private IPublisher publisher;

    public SecondObserver(IPublisher iPublisher) {
        state="";
        publisher = iPublisher;
    }

    @Override
    public void setLatestValue() {
        state = publisher.getLatestState();
    }

    public void printLatestValue() {
        System.out.println("Second observer gets the latest values as " + state);
    }
}
