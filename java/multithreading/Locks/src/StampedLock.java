import java.util.concurrent.locks.Lock;

public class StampedLock {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread thread1 = new Thread(sharedResource::stampedLockCriticalSection1);
        Thread thread2 = new Thread(sharedResource::stampedLockCriticalSection2);
        thread1.start();
//        thread2.start();
    }
}
