public class Main {
    public static void threadJoin() {
        SharedResource sr = new SharedResource();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 is executing");
            sr.toggleAvailability();
            System.out.println("Thread 1 completed");
        });

        thread1.start();
        System.out.println("Main will stop now!!!");
        try {
            thread1.join();
        } catch (Exception ignored) {

        }
        System.out.println("Main started again!!!");
    }

    public static void daemonThread() {
        SharedResource sr1 = new SharedResource();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 is executing");
            sr1.toggleAvailability();
            System.out.println("Thread 1 completed");
        });

        thread1.setDaemon(true);
        thread1.start();
        System.out.println("Main completed !!!");
    }


    public static void main(String[] args) {
        daemonThread();
    }
}
