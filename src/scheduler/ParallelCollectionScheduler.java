package scheduler;

import java.util.Collection;

public class ParallelCollectionScheduler extends CollectionScheduler {

    /**
     * Creates a new ParallelCollectionScheduler using
     * the appropriate type of Collection.
     * Do not use this constructor unless expanding the library.
     * Instead, make of of the SchedulerFactory class.
     *
     * @param subsystems The empty Collection to be used for Subsystems.
     */
    public ParallelCollectionScheduler(Collection<Subsystem> subsystems) {
        super(subsystems);
    }

    /**
     * Runs the scheduler in the current thread
     * and others using parallel streams.
     * <p>
     * The usage of this method should
     * be avoided in favor of .start(),
     * which runs the Scheduler in a new Thread.
     */
    @Override
    public synchronized void run() {

        shouldRun.set(true);

        while (shouldRun.get()) {
            subsystems
                    .parallelStream()
                    .forEach(Subsystem::runCommand);
        }

    }

}
