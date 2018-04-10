package test.Subsystems;

import scheduler.BaseSubsystem;

import java.util.concurrent.atomic.AtomicInteger;

public class Incrementer extends BaseSubsystem {

    private final AtomicInteger counter = new AtomicInteger();

    public Incrementer() {
        super();
        this.counter.set(0);
    }

    public int incrementAndReturnCounter() {
        return counter.incrementAndGet();
    }

    public int decrementAndReturnCounter() {
        return counter.decrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }

}
