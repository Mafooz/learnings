import java.util.concurrent.atomic.AtomicInteger;

public class SharedCounter {
    AtomicInteger atomicCounter = new AtomicInteger(0);
    int counter = 0;
    volatile int counterVolatile = 0;

    public void incrementCounter() {
        counter++;
    }
    public int getCounterCounter() {
        return counter;
    }
    public void incrementAtomicVariableCounter() {
        atomicCounter.getAndIncrement();
    }
    public AtomicInteger getAtomicVariableCounter() {
        return atomicCounter;
    }
    public void incrementVolatileCounter() {
        counterVolatile++;
    }
    public int getCounterCounterVolatile() {
        return counter;
    }

}
