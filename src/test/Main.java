package test;

import scheduler.Scheduler;
import scheduler.SchedulerFactory;

public class Main {

    public static void main(String[] args) {

        Scheduler scheduler;
        Incrementer advancedIncrementor;

        scheduler = SchedulerFactory.getParallelHashSetScheduler();
        advancedIncrementor = new Incrementer();

        advancedIncrementor
                .initDefaultCommand(advancedIncrementor.getPrintCommand());
        scheduler.addSubsystem(advancedIncrementor);

        scheduler.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        advancedIncrementor
                .setNewCommandToRun(advancedIncrementor.getIncrementerCommand());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        advancedIncrementor
                .setNewCommandToRun(advancedIncrementor.getDecrementerCommand());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stopScheduler();
    }

}
