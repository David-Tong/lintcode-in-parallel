import java.util.concurrent.CountDownLatch;

public class Boss implements Runnable {

    // Add any attributes needed here
    private CountDownLatch latch;

    public Boss(CountDownLatch latch) {
        // --- write your code here ---
    	this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Waiting for worker");
        // --- write your code here ---
        try {
			latch.await();
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("Start checking");
    }
}
