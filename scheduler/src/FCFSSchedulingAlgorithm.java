/** FCFSSchedulingAlgorithm.java
 * 
 * A first-come first-served scheduling algorithm.
 *
 * @author: Charles Zhu
 * CS143 - Spring 2020
 *
 */

import java.util.*;

public class FCFSSchedulingAlgorithm extends BaseSchedulingAlgorithm {

    private ArrayList<Process> jobs;
    
    class FCFSComparator implements Comparator<Process> {
    	public int compare(Process p1, Process p2) {
    		if(p1.getArrivalTime() != p2.getArrivalTime()) {
    			return Long.signum(p1.getArrivalTime() - p2.getArrivalTime());
    		}
    		return Long.signum(p1.getPID() - p2.getPID());
    	}
    }
    
    FCFSComparator comparator = new FCFSComparator();

    FCFSSchedulingAlgorithm(){
		activeJob = null;
		jobs = new ArrayList<Process>();
    }

    /** Add the new job to the correct queue.*/
    public void addJob(Process p){
    	jobs.add(p);
    	Collections.sort(jobs,comparator);
    }
    
    /** Returns true if the job was present and was removed. */
    public boolean removeJob(Process p){
		if(p == activeJob)
		    activeJob = null;
		return jobs.remove(p);
    }

    /** Transfer all the jobs in the queue of a SchedulingAlgorithm to another, such as
	when switching to another algorithm in the GUI */
    public void transferJobsTo(SchedulingAlgorithm otherAlg) {
    	throw new UnsupportedOperationException();
    }

    /** Returns the next process that should be run by the CPU, null if none available.*/
    public Process getNextJob(long currentTime){
    	Process earliest = null;
    	
    	if(!isJobFinished())
    		return activeJob;
		if(jobs.size() > 0)
			earliest = jobs.get(0);
    	activeJob = earliest;
    	return activeJob;
    }

    public String getName(){
    	return "First-Come First-Served";
    }
    
}