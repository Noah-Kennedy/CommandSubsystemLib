package scheduler;

/**
 * A representation of a SubSystem used by our model.
 * Subsystems represent objects with resources which
 * can only be used by one Command at a time.
 * <p>
 * Subsystems serve to aggregate Commands.
 * <p>
 * Each Subsystem can have up to one Command to run at a time
 * and up to one default Command to run when no command is Scheduled.
 */
interface Subsystem {

    /**
     * Runs the current scheduled Command.
     * If no Command is scheduled, this will run the default Command.
     */
    void runCommand();


    /**
     * Sets a new command to be run.
     * This method will onInterrupt and deschedule the current command.
     *
     * @param command The new command to be run.
     */
    void setNewCommandToRun(Command command);

    /**
     * Initializes the default Command.
     * Due not call this unless you are expanding the library.
     *
     * @param defaultCommand The default Command to be run by
     *                       the Scheduler when no Command is present.
     */
    void initDefaultCommand(Command defaultCommand);
}
