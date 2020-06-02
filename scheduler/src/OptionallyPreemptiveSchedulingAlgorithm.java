/** OptionallyPreemptiveSchedulingAlgorithm.java
 * 
 * An interface for algorithms that can be set to preempt processes running if a
 * 'higher priority' process appears.
 *
 * @author: Kyle Benson
 * CS143 - Spring 2020
 *
 */

public interface OptionallyPreemptiveSchedulingAlgorithm extends SchedulingAlgorithm {
    /**
     * @return Value of preemptive.
     */
    public boolean isPreemptive();
    
    /**
     * @param v Value to assign to preemptive.
     */
    public void setPreemptive(boolean v);
}