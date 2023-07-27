import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ThreadSafeCounter {
    private int i;
    // write your code
    private Lock lock;
    
    public ThreadSafeCounter() {
        this.i = 0;
        // write your code
        this.lock = new ReentrantLock();
    }
    
    public void incr() {
        // write your code
    	lock.lock();
    	i = Main.incr();
    	lock.unlock();
    }
    
    public void decr() {
        // write your code
        lock.lock();
        i = Main.decr();
        lock.unlock();
    }
    
    public int getCount() {
        return i;
    }
}