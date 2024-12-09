public class Semaphore {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread thread1 = new Thread(sharedResource::semaphoreCriticalSection1);
        Thread thread3 = new Thread(sharedResource::semaphoreCriticalSection1);
        Thread thread2 = new Thread(sharedResource::semaphoreCriticalSection2);
        Thread thread4 = new Thread(sharedResource::semaphoreCriticalSection2);
        thread1.start();
        thread3.start();
        thread2.start();
        thread4.start();
    }
}
