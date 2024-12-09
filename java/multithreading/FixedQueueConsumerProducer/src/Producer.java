public class Producer implements Runnable{

    SharedQueue sharedQueue;
    int toAdd;
    public Producer(SharedQueue sharedQueue, int toAdd) {
        this.sharedQueue = sharedQueue;
        this.toAdd = toAdd;
    }
    @Override
    public void run() {
        sharedQueue.add(toAdd);
    }
}
