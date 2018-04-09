package scheduler;

import java.util.Set;

/**
 * A Command is a model of a task to be run by a scheduler.
 * Commands work with Subsystems to form a model of the project.
 *
 * The lifecycle of a Command is as follows:
 *
 * 1. The Command is instantiated.
 *
 * 2. The Command is added to a Scheduler.
 *
 * 3. The Scheduler calls the init() method.
 *
 * 4. The Scheduler runs the execute() method repeatedly
 * until the isFinished() method returns true.
 *
 * 5. The end() method is called.
 *
 * 6. If the Command is interrupted by another Command
 * which requires the same Subsystem, the interrupted() method will be called.
 * Interrupted Commands will <b>not<b/> resume running when no longer blocked.
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
     * @return Whether or not the Command should be descheduled.
     */
    boolean isFinished();

    /**
     * Called once after the command is descheduled.
     */
    void end();

    /**
     * Called once if the command is interrupted.
     */
    void interrupted();

    /**
     * Determines whether or not this Command is blocked
     * by another Command and interrupts it if so.
     * @return Whether or not another command requires any
     * of the same Subsystems as this one.
     */
    boolean isBlocked();

    /**
     * Fetches a Set of the requiredSubsystems.
     * This is used to determine when a Command will need to be interrupted.
     * @return A Set of all required Subsystems.
     */
    Set<Subsystem> getRequiredSubsystems();
}
