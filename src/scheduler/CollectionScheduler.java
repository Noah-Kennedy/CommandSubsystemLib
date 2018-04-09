package scheduler;

import java.util.Collection;

public class CollectionScheduler extends Scheduler {
    Collection<Command> commands;

    /**
     * Runs the scheduler.
     */
    @Override
    public void run() {

    }

    /**
     * Schedules a new command.
     * This method cannot be called while the scheduler is running.
     *
     * @param command The Command to be scheduled.
     */
    @Override
    public void schedule(Command command) {

        if(this.isAlive()) {
            throw new IllegalStateException(
                    "You cannot call this method while the command is running!");
        }

        command.init();
        commands.add(command);


    }
}
