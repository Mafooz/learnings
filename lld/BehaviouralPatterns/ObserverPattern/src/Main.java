public class Main {

    public static void main(String[] args) {
        IPublisher publisher = new Publisher();
        FirstObserver firstObserver = new FirstObserver(publisher);
        SecondObserver secondObserver = new SecondObserver(publisher);

        firstObserver.printLatestValue();
        secondObserver.printLatestValue();

        publisher.registerObserver(firstObserver);
        publisher.publishChange("Change 1");
        firstObserver.printLatestValue();
        secondObserver.printLatestValue();

        publisher.registerObserver(secondObserver);
        publisher.publishChange("Change 2");
        firstObserver.printLatestValue();
        secondObserver.printLatestValue();

        publisher.deleteObserver(firstObserver);
        publisher.publishChange("Change 3");
        firstObserver.printLatestValue();
        secondObserver.printLatestValue();
    }
}
