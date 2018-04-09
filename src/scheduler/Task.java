package scheduler;

public interface Task {
    void init();
    void execute();
    boolean isFinished();
    void end();
    void interrupted();
}
