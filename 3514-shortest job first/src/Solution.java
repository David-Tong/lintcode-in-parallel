import java.util.*;

/**
 * Define of Process:
 * public class Process {
 *
 *     public Integer id, arrived, runtime;
 *
 *     public Process(Integer id, Integer arrived, Integer runtime) {
 *         this.id = id;
 *         this.arrived = arrived;
 *         this.runtime = runtime;
 *     }
 * }
 */
public class Solution {

    public int[][] SJF(List<Process> processes) {
        // --- Write your code here ---
    	int capacity = processes.size();
    	int[][] ans = new int[2][capacity];
    	
    	Collections.sort(processes, (p1, p2) -> p1.arrived - p2.arrived);
    	PriorityQueue<Process> pq = new PriorityQueue<Process>(capacity, new ProcessComparator());
    	pq.add(processes.get(0));
    	
    	int index = 1;
    	int time = 0;
    	while (pq.size() > 0) {
    		Process process = pq.poll();
    		time += process.runtime;
    		// update ans
    		ans[0][process.id] = time - process.arrived;
    		ans[1][process.id] = ans[0][process.id] - process.runtime;
    		while (index < capacity && processes.get(index).arrived <= time) {
    			pq.add(processes.get(index));
    			index += 1;
    		}
    	}
    	
    	//System.out.println(ans);
        return ans;
    }
    
    class ProcessComparator implements Comparator<Process> {

		@Override
		public int compare(Process p1, Process p2) {
			if (p1.runtime != p2.runtime) {
				return p1.runtime - p2.runtime;
			} else {
				if (p1.arrived != p2.arrived) {
					return p1.arrived - p2.arrived;
				} else {
					return p1.id - p2.id;
				}
			}
		}
    	
    }

}
