package scheduler;

/**
 * A representation of a SubSystem used by our model.
 * Subsystems represent objects with resources which
 * can only be used by one Command at a time.
 *
 * Subsystems serve to aggregate Commands.
 *
 * Each Subsystem can have up to one Command to run at a time
 * and up to one default Command to run when no command is Scheduled.
 */
public interface Subsystem {

    /**
     * Runs the current scheduled Command.
     * If no Command is scheduled, this will run the default Command.
     */
    void runCommand();


    /**
     * Sets a new command to be run.
     * This method will interrupt and deschedule the current command.
     * @param command The new command to be run.
     */
    void setNewCommandToRun(Command command);
}
