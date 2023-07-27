import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private int account;
    // write your code
    private Lock lock;
    private Condition condition;
    
    public Bank(int account) {
        this.account = account;
        // write your code
        this.lock = new ReentrantLock();
        this.condition = this.lock.newCondition();
    }
    
    public void saveMoney(int amount) throws Exception {
        // write your code
    	try {
    		lock.lock();
    		account = Main.saveOperation(account, amount);
    		condition.signalAll();
    	} finally {
    		lock.unlock();
    	}
    }
    
    public void withdrawMoney(int amount) throws Exception {
        // write your code
    	try {
    		lock.lock();
    		while (account < amount) {
    			condition.await();
    		}
    		account = Main.withdrawOperation(account, amount);
    	} finally {
    		lock.unlock();
    	}
    }
    
    public int checkAccount(){
        // write your code
        return account;
    }
}