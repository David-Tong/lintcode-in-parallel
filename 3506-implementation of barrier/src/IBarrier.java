// You can import any package here.

public class IBarrier {

    // You can add any attribute needed here.
	private int n;

    public IBarrier(int n) {
        // Init here.
    	this.n = n;
    }

    public void arriveAndWait() throws Exception {
        // --- Write your code here ---
    	this.n--;
    	
    	if (this.n == 0) {
    		this.notify();
    	}
    	this.wait();
    }

}
