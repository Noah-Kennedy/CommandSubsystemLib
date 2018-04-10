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
     * Constructs a Subsystem without a default Command.
     */
    public AbstractSubsystem() {

        this.currentCommand = null;
        this.defaultCommand = null;

    }

    /**
     * Runs the current scheduled Command.
     * If no Command is scheduled, this will run the default Command.
     */
    @Override
    public synchronized void runCommand() {

        if (currentCommand != null) {

            if (!currentCommand.isFinished()) {

                currentCommand.execute();

            } else {

                currentCommand.end();

                currentCommand = null;

                if (defaultCommand != null) {

                    defaultCommand.init();

                }

            }

        } else {

            if (defaultCommand != null) {

                defaultCommand.execute();

            }

        }
    }

    /**
     * Sets a new command to be run.
     * This method will onInterrupt and deschedule the current command.
     *
     * @param command The new command to be run.
     */
    @Override
    public synchronized void setNewCommandToRun(Command command) {

        if (this.currentCommand != null) {
            this.currentCommand.onInterrupt();
        }

        this.currentCommand = command;

        this.currentCommand.init();

    }

    /**
     * Initializes the default Command.
     * Due not call this unless you are expanding the library.
     *
     * @param defaultCommand The default Command to be run by
     *                       the Scheduler when no Command is present.
     */
    @Override
    public void initDefaultCommand(Command defaultCommand) {

        /*if(defaultCommand != null) {
            throw new IllegalStateException(
                    "You cannot change the default command once it has been set!");
        }*/

        this.defaultCommand = defaultCommand;
    }

}
