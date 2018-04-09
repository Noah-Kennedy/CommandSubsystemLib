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
     * Schedules a new command.
     * This method cannot be called while the scheduler is running.
     * @param command The Command to be scheduled.
     */
    public abstract void schedule(Command command);

}
