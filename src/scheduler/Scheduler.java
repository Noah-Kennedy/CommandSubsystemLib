package scheduler;

/**
 * Schedules and runs the Commands.
 * Commands are added to Subsystems,
 * which run the commands in a cycle controlled by the Scheduler.
 *
 * @author Noah Kennedy
 */
public abstract class Scheduler extends Thread {

    /**
     * Runs the scheduler in the current thread.
     *
     * The usage of this method should
     * be avoided in favor of .start(),
     * which runs the Scheduler in a new Thread.
     */
    public abstract void run();

    /**
     * Adds a Subsystem to the Scheduler.
     * @param subsystem The Subsystem to be added.
     */
    public abstract void addSubsystem(Subsystem subsystem);

    /**
     * Stops the Scheduler.
     */
    public abstract void stopScheduler();

}
