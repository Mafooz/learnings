public class Main {

    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue(5);

        Thread thread1 = new Thread(new Producer(sharedQueue, 1));
        Thread thread2 = new Thread(new Producer(sharedQueue, 2));
        Thread thread3 = new Thread(new Producer(sharedQueue, 3));
        Thread thread4 = new Thread(new Producer(sharedQueue, 4));
        Thread thread5 = new Thread(new Producer(sharedQueue, 5));
        Thread thread6 = new Thread(new Producer(sharedQueue, 6));
        Thread thread7 = new Thread(new Producer(sharedQueue, 7));
        Thread thread8 = new Thread(new Producer(sharedQueue, 8));
        Thread thread9 = new Thread(new Producer(sharedQueue, 9));
        Thread thread10 = new Thread(new Producer(sharedQueue, 10));
        Thread thread11 = new Thread(new Consumer(sharedQueue));
        Thread thread12 = new Thread(new Consumer(sharedQueue));
        Thread thread13 = new Thread(new Consumer(sharedQueue));
        Thread thread14 = new Thread(new Consumer(sharedQueue));
        Thread thread15 = new Thread(new Consumer(sharedQueue));
        Thread thread16 = new Thread(new Consumer(sharedQueue));
        Thread thread17 = new Thread(new Consumer(sharedQueue));
        Thread thread18 = new Thread(new Consumer(sharedQueue));
        Thread thread19 = new Thread(new Consumer(sharedQueue));
        Thread thread20 = new Thread(new Consumer(sharedQueue));
        Thread thread21 = new Thread(new Consumer(sharedQueue));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
        thread12.start();
        thread13.start();
        thread14.start();
        thread15.start();
        thread16.start();
        thread17.start();
        thread18.start();
        thread19.start();
        thread20.start();
    }
}
