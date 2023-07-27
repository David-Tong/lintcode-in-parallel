public class Solution implements Runnable {
	
	private static volatile int counter = 0;
	
    private int threadId;

    private Object o;
    
    // You can add other member variables needed.
    // -- write your code here --

    public Solution(int threadId, Object o) {
        this.threadId = threadId;
        this.o = o;
    }

    @Override
    public void run() {
        // -- write your code here --
    	while (counter < 28) {
    		synchronized (this.o) {
    			for (int i=0; i<5; i++) {
    				counter++;
    				System.out.printf("Thread %d: %d \n", this.threadId, counter);
    			}
    			try {
					this.o.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			this.o.notify();
    		}
    		
    	}
    }
}