import java.util.concurrent.locks.Lock;

public class ReentrantLock {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread thread1 = new Thread(sharedResource::ReentrantCriticalSection);
        Thread thread2 = new Thread(sharedResource::ReentrantCriticalSection);
        thread1.start();
        thread2.start();
    }
}
