package scheduler;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

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
     * @return
     */
    public static Scheduler getHashSetScheduler() {
        return new CollectionScheduler(new HashSet<>());
    }

}
