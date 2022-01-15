public class Deadline extends Task {
    protected String deadlineTime;

    private Deadline(String description, boolean isDone, String deadlineTime) {
        super(description, isDone);
        this.deadlineTime = deadlineTime;
    }

    public Deadline(String description, String DeadlineTime) {
        this(description, false, DeadlineTime);
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return String.format("[D] [X] %s (at: %s)", this.description, this.deadlineTime);
        } else {
            return String.format("[D] [ ] %s (at: %s)", this.description, this.deadlineTime);
        }
    }
}
