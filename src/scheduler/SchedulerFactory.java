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
     * @return A CollectionScheduler using a HashSet.
     */
    public static Scheduler getHashSetScheduler() {
        return new CollectionScheduler(new HashSet<>());
    }

}
