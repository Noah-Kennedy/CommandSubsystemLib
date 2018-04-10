package scheduler;

import java.util.HashSet;

/**
 * Factory class for producing different schedulers.
 * Use this instead of the constructors to generate Scheduler objects.
 *
 * @author Noah Kennedy
 */
public class SchedulerFactory {

    /**
     * Factory method for generating a HashSetScheduler.
     * Subsystems are held in a HashSet.
     *
     * @return A CollectionScheduler using a HashSet.
     */
    public static Scheduler getHashSetScheduler() {
        return new CollectionScheduler(new HashSet<>());
    }

    /**
     * Factory method for generating a ParallelHashSetScheduler.
     * Subsystems will be held in a HashSet.
     * The Scheduler will parallelize the work of running Commands using parallel streams.
     *
     * @return A ParallelCollectionSchedule using a HashSet.
     */
    public static Scheduler getParallelHashSetScheduler() {
        return new ParallelCollectionScheduler(new HashSet<>());
    }

}
