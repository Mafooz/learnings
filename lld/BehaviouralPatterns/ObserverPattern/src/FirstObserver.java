public class FirstObserver implements IObserver{

    private String state;
    private IPublisher publisher;

    public FirstObserver(IPublisher iPublisher) {
        state="";
        publisher = iPublisher;
    }

    @Override
    public void setLatestValue() {
        state = publisher.getLatestState();
    }

    public void printLatestValue() {
        System.out.println("First observer gets the latest values as " + state);
    }
}
