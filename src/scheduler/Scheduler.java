package scheduler;

/**
 * Schedules and runs the Commands.
 */
public abstract class Scheduler extends Thread {

    /**
     * Runs the scheduler.
     */
    public abstract void run();

    /**
     * Schedules a new Command.
     * This method is less efficient than
     * the addCommand(Command) method, but it is safe to
     * use when the Scheduler is running.
     * @param command The Command to be scheduled.
     */
    public abstract void schedule(Command command);

    /**
     * Adds a Subsystem to the Scheduler.
     * @param subsystem The Subsystem to add.
     */
    public abstract void addSubsystem(Subsystem subsystem);

    /**
     * Adds a new Command.
     * This is much more efficient than the schedule method,
     * but it cannot be called while the Scheduler is running.
     * @param command The Command to be added.
     */
    public abstract void addCommand(Command command);

    /**
     * Stops the Scheduler.
     */
    public abstract void stopScheduler();
}
