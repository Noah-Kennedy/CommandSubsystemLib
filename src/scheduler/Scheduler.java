package scheduler;

import java.util.Iterator;

public class Scheduler extends Thread implements Iterable {
    private TaskNode head;

    public Scheduler() {
        head = new TaskNode(null, head, head);
    }

    public void add(Task task) {
        TaskNode newNode;

        newNode = new TaskNode(task, head.getNext(), head);
        head.getNext().setPrevious(newNode);
        head.setNext(newNode);
    }

    public Iterator iterator() {
        return new SchedulerIterator(head);
    }

    private class SchedulerIterator implements Iterator {

        private TaskNode current;

        public SchedulerIterator(TaskNode current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current.getNext().isHead();
        }

        public TaskNode next() {
            return current = current.getNext();
        }

    }
}
