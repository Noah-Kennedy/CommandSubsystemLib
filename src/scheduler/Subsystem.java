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
     */
    void initDefaultCommand();
    Command getCurrentCommand();
    void setCurrentCommand(Command command);
}
