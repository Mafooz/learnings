import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue {
    int size;
    Queue<Integer> queue = new LinkedList<>();

    SharedQueue(int size) {
        this.size = size;
    }

    public synchronized void add(Integer y) {
        while(queue.size()>=size) {
            try{
                System.out.println("Queue is full!!! Thread " + Thread.currentThread().getName() + " is waiting");
                wait();
            }
            catch (Exception e) {
                // some handling
            }
        }
        System.out.println("Adding " + y + " to queue of size " + queue.size() + " using thread " + Thread.currentThread().getName());
        queue.add(y);
        notifyAll();
    }

    public synchronized void consume() {
        while(queue.isEmpty()) {
            try {
                System.out.println("Queue is empty!!!. Thread " + Thread.currentThread().getName() + " is waiting");
                wait();
            }
            catch (Exception e) {
                // some handling of exception
            }
        }
        System.out.println("Consuming element from the queue");
        System.out.println(Thread.currentThread().getName() + " is consuming " + queue.poll());
        notifyAll();
    }
}
