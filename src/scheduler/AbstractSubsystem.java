package scheduler;

/**
 * A class which implements all of the methods within the Subsystem interface.
 * Other Subsystems should extend this if possible.
 *
 * @author Noah Kennedy
 */
public class AbstractSubsystem implements Subsystem {

    private Command defaultCommand;
    private Command currentCommand;

    /**
     * Initializes the default command.
     * This method can be left blank depending on the implementation.
     * If the default command doesn't exist it should be null.
     *
     * @param defaultCommand The default command.
     */
    @Override
    public void setDefaultCommand(Command defaultCommand) {

        this.defaultCommand = defaultCommand;

    }

    /**
     * Returns the default Command to be run if there is no other Command.
     * If there is no default command then this should return null.
     *
     * @return The default command, if any.
     */
    @Override
    public Command getDefaultCommand() {
        return defaultCommand;
    }

    /**
     * Returns the command which should currently be running.
     *
     * @return The current command.
     */
    @Override
    public Command getCurrentCommand() {
        return currentCommand;
    }

    /**
     * Sets a new command to be run.
     * This method will interrupt and deschedule the current command.
     *
     * @param command The new command to be run.
     */
    @Override
    public void setCurrentCommand(Command command) {
        this.currentCommand = command;
    }

}
