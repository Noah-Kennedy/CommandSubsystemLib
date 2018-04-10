package test.Subsystems;

import scheduler.Command;
import scheduler.CommandFactory;
import test.Main;

import java.util.concurrent.atomic.AtomicInteger;

public class AdvancedIncrementor {

    private final AtomicInteger counter = new AtomicInteger();

    public AdvancedIncrementor() {
        super();
        this.counter.set(0);
    }

    private final Command getIncrementor() {
        return CommandFactory.generateCommand(
                () -> {},
                () -> System.out.println(counter.incrementAndGet()),
                () -> System.out.println("The final value of the counter is "
                        + counter),
                () -> System.out.println("The value of the counter when we were interrupted was "
                        + counter),
                () -> counter.get() > 100);
    }

}
