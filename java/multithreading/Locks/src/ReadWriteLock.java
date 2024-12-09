public class ReadWriteLock {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread thread1 = new Thread(sharedResource::readCriticalSection);
        Thread thread2 = new Thread(sharedResource::readCriticalSection);
        Thread thread3 = new Thread(sharedResource::readCriticalSection);
        Thread thread4 = new Thread(sharedResource::writeCriticalSection);
        Thread thread5 = new Thread(sharedResource::writeCriticalSection);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
