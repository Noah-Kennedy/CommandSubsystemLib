package test.Commands;

import scheduler.Command;
import test.Main;

public class Decrementor implements Command {
    /**
     * Called once when this command is first scheduled.
     */
    @Override
    public void init() {

        System.out.println("The initial value of the counter is"
                + Main.incrementer.getCounter());

    }

    /**
     * Called repeatedly while this command is scheduled.
     */
    @Override
    public void execute() {
        System.out.println(
                Main.incrementer.decrementAndReturnCounter());
    }

    /**
     * When this returns true, the Scheduler will deschedule the Command.
     *
     * @return Whether or not the Command should be descheduled.
     */
    @Override
    public boolean isFinished() {
        return Main.incrementer.getCounter() < 100;
    }

    /**
     * Called once after the command is descheduled.
     */
    @Override
    public void end() {

        System.out.println("The final value of the counter is "
                + Main.incrementer.getCounter());

    }

    /**
     * Called once if the command is onInterrupt.
     */
    @Override
    public void onInterrupt() {

        System.out.println("The value of the counter when we were interrupted was "
                + Main.incrementer.getCounter());

    }
}