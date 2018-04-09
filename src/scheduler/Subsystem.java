package scheduler;

/**
 * A representation of a SubSystem used by our model.
 * Subsystems represent objects with resources which
 * can only be used by one command at a time.
 */
public interface Subsystem {

    /**
     * Initializes the default command.
     * This method can be left blank depending on the implementation.
     * If the default command doesn't exist it should be null.
     */
    void setDefaultCommand(Command defaultCommand);

    /**
     * Returns the default Command to be run if there is no other Command.
     * If there is no default command then this should return null.
     * @return The default command, if any.
     */
    Command getDefaultCommand();

    /**
     * Returns the command which should currently be running.
     * @return The current command.
     */
    Command getCurrentCommand();

    /**
     * Sets a new command to be run.
     * This method will interrupt and deschedule the current command.
     * @param command The new command to be run.
     */
    void setCurrentCommand(Command command);
}
