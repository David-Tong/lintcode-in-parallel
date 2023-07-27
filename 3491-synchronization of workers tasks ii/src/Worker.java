import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Runnable {

    // Add any attributes needed here
    private CyclicBarrier barrier;
    private Tasks tasks;

    public Worker(CyclicBarrier barrier) {
        // --- write your code here ---
        this.barrier = barrier;
        this.tasks = new Tasks();
    }

    @Override
    public void run() {
        // First task
        // --- write your code here ---
    	tasks.pileDriving();
       
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        System.out.println("@Done");
        try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Second task
        // --- write your code here ---
        tasks.buildBridge();     
    }
}
