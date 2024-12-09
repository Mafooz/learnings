import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    Lock reentrantLock = new ReentrantLock();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Semaphore semaphore = new Semaphore(2);
    StampedLock stampedLock = new StampedLock();
    boolean isAvailable = false;
    int a=11;
    public void ReentrantCriticalSection() {
        try {
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + " is inside the CS");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " woke up");

        }
        catch (Exception e) {

        }
        finally {
            reentrantLock.unlock();
            System.out.println(Thread.currentThread().getName() + " released the lock CS");
        }
    }

    public void readCriticalSection() {
        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " is inside read section CS");
            System.out.println(Thread.currentThread().getName() + " prints isAvailable " + isAvailable);
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " woke up");
        }
        catch (Exception e) {

        }
        finally {
            readWriteLock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + " released the read lock CS");
        }
    }
    public void writeCriticalSection() {
        try {
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " is inside write section CS");
            this.isAvailable = !isAvailable;
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " woke up");
        }
        catch (Exception e) {

        }
        finally {
            readWriteLock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName() + " released the read lock CS");
        }
    }
    public void semaphoreCriticalSection1() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is inside semaphore1 section CS");
            this.isAvailable = !isAvailable;
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " woke up");
        }
        catch (Exception e) {

        }
        finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " released the semaphore1 lock CS");
        }
    }
    public void semaphoreCriticalSection2() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is inside semaphore2 section CS");
            this.isAvailable = !isAvailable;
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " woke up");
        }
        catch (Exception e) {

        }
        finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " released the semaphore2 lock CS");
        }
    }

    public void stampedLockCriticalSection1() {
        long stamp = 0;
        try {
            stamp = stampedLock.tryOptimisticRead();
            a=10;
            System.out.println(Thread.currentThread().getName() + " is inside semaphore2 section CS");
            Thread.sleep(5000);
            if (stampedLock.validate(stamp)) {
                System.out.println(Thread.currentThread().getName() + ": No changes done");
            }
            else {
                a=11;
                System.out.println(Thread.currentThread().getName() + ": Rollback");
            }
        }
        catch (Exception e) {

        }
        finally {
            System.out.println(Thread.currentThread().getName() + " released the semaphore2 lock CS");
        }
    }

    public void stampedLockCriticalSection2() {
        long stamp = 0;
        try {
            stamp = stampedLock.writeLock();
            a=9;
            Thread.sleep(5000);
        }
        catch (Exception e) {

        }
        finally {
            stampedLock.unlock(stamp);
            System.out.println(Thread.currentThread().getName() + " released the stamp lock CS");
        }
    }


}
