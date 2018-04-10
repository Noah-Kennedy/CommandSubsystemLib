package test;

import scheduler.Scheduler;
import scheduler.SchedulerFactory;
import test.Commands.Decrementor;
import test.Commands.IncrementForEver;
import test.Subsystems.Incrementer;

public class Main {

    public static final Incrementer incrementer = new Incrementer();

    public static void main(String[] args) {
        Scheduler scheduler = SchedulerFactory.getHashSetScheduler();
        scheduler.addSubsystem(incrementer);

        scheduler.start();
        incrementer.setNewCommandToRun(new IncrementForEver());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        incrementer.setNewCommandToRun(new Decrementor());

    }

}
