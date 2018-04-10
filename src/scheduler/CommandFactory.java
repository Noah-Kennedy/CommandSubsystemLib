package scheduler;

import java.util.function.BooleanSupplier;

/**
 * A factory for creating Commands in a functional manner.
 * This is a good idea to employ, as it allows for the
 * generation of Commands without going through the boilerplate process
 * of extending Command and calling methods in a static Subsystem.
 *
 * @author Noah Kennedy
 */
public class CommandFactory {

    /**
     * Generates a new Command using the supplied functional interfaces as it's methods.
     *
     * @param init        Called once when this command is first scheduled.
     * @param execute     Called repeatedly while this command is scheduled.
     * @param end         Called once after the command is descheduled.
     * @param onInterrupt Called once if the command is onInterrupt.
     * @param isFinished  When this returns true, the Scheduler will deschedule the Command.
     * @return A Command generated from the provided components.
     */
    public static Command generateCommand(Runnable init, Runnable execute,
                                          Runnable end, Runnable onInterrupt,
                                          BooleanSupplier isFinished) {
        return new Command() {
            @Override
            public void init() {
                init.run();
            }

            @Override
            public void execute() {
                execute.run();
            }

            @Override
            public boolean isFinished() {
                return isFinished.getAsBoolean();
            }

            @Override
            public void end() {
                end.run();
            }

            @Override
            public void onInterrupt() {
                onInterrupt.run();
            }
        };
    }
}
