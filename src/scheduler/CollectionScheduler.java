package scheduler;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

public class CollectionScheduler extends Scheduler {

    protected final Collection<Subsystem> subsystems;
    protected final AtomicBoolean shouldRun;

    /**
     * Creates a new CollectionScheduler using
     * the appropriate type of Collection.
     * Do not use this constructor unless expanding the library.
     * Instead, make of of the SchedulerFactory class.
     *
     * @param subsystems The empty Collection to be used for Subsystems.
     */
    public CollectionScheduler(Collection<Subsystem> subsystems) {
        this.subsystems = subsystems;
        this.shouldRun = new AtomicBoolean();
    }


    /**
     * Runs the scheduler in the current thread.
     * <p>
     * The usage of this method should
     * be avoided in favor of .start(),
     * which runs the Scheduler in a new Thread.
     */
    @Override
    public synchronized void run() {

        shouldRun.set(true);

        while (shouldRun.get()) {
            subsystems.forEach(Subsystem::runCommand);
        }

    }

    /**
     * Adds a Subsystem to the Scheduler.
     *
     * @param subsystem The Subsystem to be added.
     */
    @Override
    public void addSubsystem(Subsystem subsystem) {

        subsystems.add(subsystem);

    }

    /**
     * Stops the Scheduler.
     */
    @Override
    public void stopScheduler() {

        shouldRun.set(false);

    }

}

