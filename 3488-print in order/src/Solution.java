import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// You can import any package needed here.

public class Solution {

    // You can add any attributes needed here.
	private int counter;
	private Lock lock;
	private Condition condition;
	private Condition condition2;

    public Solution() {
        this.counter = 0;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
        this.condition2 = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
    	lock.lock();
    	try {
    		if (counter != 0) {
    			condition.await();
    		}
    		// printFirst.run() output "First". Do not change this line
            printFirst.run();
            counter++;
            condition.signal();
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	} finally {
    		lock.unlock();
    	}
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	lock.lock();
    	try {
    		if (counter != 1) {
    			condition.await();
    		}
    		// printSecond.run() output "First". Do not change this line
            printSecond.run();
            counter++;
            condition2.signal();
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	} finally {
    		lock.unlock();
    	}
    }

    public void third(Runnable printThird) throws InterruptedException {
    	lock.lock();
    	try {
    		if (counter != 2) {
    			condition2.await();
    		}
    		// printThird.run() output "First". Do not change this line
            printThird.run();
            counter++;
            condition.signal();
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	} finally {
    		lock.unlock();
    	}
    }

}
