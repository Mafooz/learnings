public class AtomicVariables {

    public static void main(String[] args) throws InterruptedException {
        SharedCounter sharedCounter = new SharedCounter();

        Thread thread1 = new Thread(() -> {
            for(int i=0;i<700;i++) {
                sharedCounter.incrementCounter();
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i=0;i<700;i++) {
                sharedCounter.incrementCounter();
            }
        });
        Thread thread3 = new Thread(() -> {
            for(int i=0;i<700;i++) {
                sharedCounter.incrementAtomicVariableCounter();
            }
        });
        Thread thread4 = new Thread(() -> {
            for(int i=0;i<700;i++) {
                sharedCounter.incrementAtomicVariableCounter();
            }
        });
        Thread thread5 = new Thread(() -> {
            for(int i=0;i<700;i++) {
                sharedCounter.incrementVolatileCounter();
            }
        });
        Thread thread6 =  new Thread(() -> {
            for(int i=0;i<700;i++) {
                sharedCounter.incrementVolatileCounter();
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        System.out.println("Normal counter sum: " + sharedCounter.getCounterCounter());
        System.out.println("Atomic counter sum: " + sharedCounter.getAtomicVariableCounter());
        System.out.println("Volatile counter sum: " + sharedCounter.getCounterCounterVolatile());
    }
}
