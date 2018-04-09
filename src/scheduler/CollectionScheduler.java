package scheduler;

import java.util.Collection;

public class CollectionScheduler extends Scheduler {

    private Collection<Command> commands;
    private Collection<Subsystem> subsystems;
    private boolean shouldRun;

    /**
     * Creates a new CollectionScheduler using
     * the appropriate type of Collection.
     * Do not use this constructor unless expanding the library.
     * Instead, make of of the SchedulerFactory class.
     *
     * @param commands   The empty Collection to be used for Commands.
     * @param subsystems The empty Collection to be used for Subsystems.
     */
    public CollectionScheduler(Collection<Command> commands, Collection<Subsystem> subsystems) {
        this.commands = commands;
        this.subsystems = subsystems;
    }

    /**
     * Do not use. Use .start() instead.
     */
    @Override
    public void run() {

        while (shouldRun) {
            runCycle();
        }

    }

    private synchronized void runCycle() {

        subsystems
                .stream()
                .map(Subsystem::getCurrentCommand)
                .forEach();

    }

    /**
     * Stops the Scheduler.
     */
    @Override
    public synchronized void stopScheduler() {
        shouldRun = false;
    }

    /**
     * Starts the Scheduler in a new Thread.
     */
    @Override
    public void start() {

        shouldRun = true;
        super.start();

    }


    /**
     * Schedules a new command.
     * This method is less efficient than
     * the addCommand(Command) method, but it is safe to
     * use when the Scheduler is running.
     *
     * @param command The Command to be scheduled.
     */
    @Override
    public synchronized void schedule(Command command) {

        command
                .getRequiredSubsystem()
                .getCurrentCommand()
                .interrupt();

        command
                .getRequiredSubsystem()
                .setCurrentCommand(command);

        command.init();

    }

    /**
     * Adds a Subsystem to the Scheduler.
     *
     * @param subsystem The Subsystem to add.
     */
    @Override
    public void addSubsystem(Subsystem subsystem) {
        subsystems.add(subsystem);
    }

    /**
     * Adds a new Command.
     * This is much more efficient than the schedule method,
     * but it cannot be called while the Scheduler is running.
     *
     * @param command The Command to be added.
     */
    @Override
    public void addCommand(Command command) {

        if (this.isAlive()) {
            throw new IllegalStateException(
                    "You cannot call this method while the command is running!");
        }

        commands.add(command);

    }

}

