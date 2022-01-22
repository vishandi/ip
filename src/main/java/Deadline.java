public class Deadline extends Task {
    protected String deadlineTime;

    public Deadline(String description, boolean isDone, String deadlineTime) {
        super(description, isDone);
        this.deadlineTime = deadlineTime;
    }

    public Deadline(String description, String DeadlineTime) {
        this(description, false, DeadlineTime);
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return String.format("[D][X] %s (by: %s)", this.description, this.deadlineTime);
        } else {
            return String.format("[D][ ] %s (by: %s)", this.description, this.deadlineTime);
        }
    }
}
