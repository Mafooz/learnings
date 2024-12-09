public class Consumer implements Runnable{

    SharedQueue sharedQueue;

    public Consumer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
    @Override
    public void run() {
        sharedQueue.consume();
    }
}
