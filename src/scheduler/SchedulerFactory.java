package scheduler;

import java.util.LinkedList;
import java.util.TreeSet;

public class SchedulerFactory {

    public static CollectionScheduler getTreeSetScheduler() {
        return new CollectionScheduler(new TreeSet<>(), new TreeSet<>());
    }

    public static CollectionScheduler getLinkedListScheduler() {
        return new CollectionScheduler(new LinkedList<>(), new LinkedList<>());
    }
}
