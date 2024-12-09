public interface IPublisher {
    public void registerObserver(IObserver observer);
    public void deleteObserver(IObserver observer);
    public void publishChange(String changedValue);
    public String getLatestState();
}
