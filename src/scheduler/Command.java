package scheduler;

/**
 * A Command is a model of a task to be run by a scheduler.
 * Commands work with Subsystems to form a model of the project.
 * <p>
 * The lifecycle of a Command is as follows:
 * <p>
 * 1. The Command is instantiated.
 * <p>
 * 2. The Command is added to a Scheduler.
 * <p>
 * 3. The Scheduler calls the init() method.
 * <p>
 * 4. The Scheduler runs the execute() method repeatedly
 * until the isFinished() method returns true.
 * <p>
 * 5. The end() method is called.
 * <p>
 * 6. If the Command is onInterrupt by another Command
 * which requires the same Subsystem, the onInterrupt() method will be called.
 * Interrupted Commands will <b>not</b> resume running when no longer blocked.
 *
 * @author Noah Kennedy
 */
public interface Command {

    /**
     * Called once when this command is first scheduled.
     */
    void init();

    /**
     * Called repeatedly while this command is scheduled.
     */
    void execute();

    /**
     * When this returns true, the Scheduler will deschedule the Command.
     *
     * @return Whether or not the Command should be descheduled.
     */
    boolean isFinished();

    /**
     * Called once after the command is descheduled.
     */
    void end();

    /**
     * Called once if the command is onInterrupt.
     */
    void onInterrupt();
}
