package test;

import scheduler.BaseSubsystem;
import scheduler.Command;
import scheduler.CommandFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class Incrementer extends BaseSubsystem {

    private final AtomicInteger counter = new AtomicInteger();

    public Incrementer() {
        super();
        this.counter.set(0);
    }

    public Command getIncrementerCommand() {
        return CommandFactory.generateCommand(
                () -> {},
                () -> System.out.println(counter.incrementAndGet()),
                () -> System.out.println("The final value of the counter is "
                        + counter),
                () -> System.out.println("The value of the counter when we were interrupted was "
                        + counter),
                () -> counter.get() >= 1000);
    }

    public Command getPrintCommand() {
        return CommandFactory.generateCommand(
                () -> {},
                () -> System.out.println(counter.get()),
                () -> {},
                () -> {},
                () -> false);
    }

    public Command getDecrementerCommand() {
        return CommandFactory.generateCommand(
                () -> {},
                () -> System.out.println(counter.decrementAndGet()),
                () -> System.out.println("The final value of the counter is "
                        + counter),
                () -> System.out.println("The value of the counter when we were interrupted was "
                        + counter),
                () -> counter.get() <= 100);
    }

}
