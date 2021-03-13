package seedu.duke.teamplannerclasses;

public class Task {
    protected String task;
    protected int priority;
    protected boolean isDone;

    public Task(String task, int priority, boolean isDone) {
        this.task = task;
        this.priority = priority;
        this.isDone = isDone;
    }

    public String getTask() {
        return task;
    }

    public int priorityLevel() {
        return priority;
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return task;
    }
}
