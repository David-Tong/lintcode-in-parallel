import java.util.concurrent.Semaphore;

public class Person implements Runnable {

    private String name;

    private Semaphore semaphore;

    private Actions actions;

    public Person(String name, Semaphore semaphore, Actions actions) {
        // --- write your code here ---
    	this.name = name;
    	this.semaphore = semaphore;
    	this.actions = actions;
    }

    @Override
    public void run() {
        // use `actions.enter()` while entering
        // use `actions.pass()` after passed
        // --- write your code here ---
        try {
			semaphore.acquire();
			actions.enter(name);
			actions.pass(name);
	        semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
