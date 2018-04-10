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
     * Constructs a Subsystem with a default Command.
     * @param defaultCommand The default Command for the Subsystem.
     */
    public AbstractSubsystem(Command defaultCommand) {

        this.currentCommand = null;
        this.defaultCommand = defaultCommand;
        defaultCommand.init();

    }

    /**
     * Constructs a Subsystem without a default Command.
     */
    public AbstractSubsystem() {

        this.currentCommand = null;
        this.defaultCommand = null;

    }

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


    @Override
    public synchronized void setNewCommandToRun(Command command) {

        this.currentCommand.interrupt();

        this.currentCommand = command;

        this.currentCommand.init();

    }

}
