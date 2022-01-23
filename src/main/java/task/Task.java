package task;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for Task.
     * @param description
     * @param isDone
     */
    protected Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Gets String that corresponds to the Task to be saved.
     * @return String
     */
    public abstract String getSaveMessage();

    /**
     * Marks the Task as Done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Unmark the Task as Done.
     */
    public void unmarkAsDone() {
        this.isDone = false;
    }

    /**
     * Returns the processed status of the task.
     * @return true if the task is done.
     */
    public boolean isDone() {
        return isDone;
    }

    public String getDescription() {
        return this.description;
    }
}