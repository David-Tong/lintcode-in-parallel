import java.util.concurrent.Semaphore;

public class Solution {

    private final int[] arr1;

    private final int[] arr2;

    // You can add any attribute you need.
    private int idx1;
    private int idx2;
    private int steps;
    private Object lock;

    public Solution(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.idx1 = 0;
        this.idx2 = 0;
        this.steps = 0;
        this.lock = new Object();
    }

    public void printArr1() {
        // --- write your code here ---
    	while (idx1 < arr1.length) {
    		synchronized(lock) {
    			if (steps % 2 == 1) {
    				try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			} 
    			System.out.print(arr1[idx1] + " ");
    			idx1++;
    			steps++;
    			lock.notify();
    		}
    	}
    }

    public void printArr2() {
        // --- write your code here ---
    	while (idx2 < arr2.length) {
    		synchronized(lock) {
    			if (steps % 2 == 0) {
    				try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			} 
    			System.out.print(arr2[idx2] + " ");
    			idx2++;
    			steps++;
    			lock.notify();
    		}
    	}
    }

}
