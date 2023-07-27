import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

    // Add any attributes needed here
    private CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        // --- write your code here ---
        this.latch = latch;
    }

    public void work() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // --- write your code here ---
        work();
        latch.countDown();
        System.out.println("@Done");
    }
}
