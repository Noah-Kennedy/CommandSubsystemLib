package scheduler;

public class TaskNode {

    private TaskNode next;
    private TaskNode previous;
    private final Task task;

    public TaskNode(Task task, TaskNode next, TaskNode previous) {

        this.task = task;
        this.next = next;
        this.previous = previous;

        task.init();

    }

    public void run() {

        if(!task.isFinished()) {
            task.execute();
        } else {
            task.end();
        }

    }

    public boolean isHead() {
        return task == null;
    }

    public boolean taskEquals(Task other) {
        return this.task.equals(other);
    }

    public void setNext(TaskNode next) {
        this.next = next;
    }

    public void setPrevious(TaskNode previous) {
        this.previous = previous;
    }

    public TaskNode getNext() {
        return this.next;
    }

    public TaskNode getPrevious() {
        return previous;
    }


}
