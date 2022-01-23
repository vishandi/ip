package task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDate deadlineTime;

    public Deadline(String description, boolean isDone, LocalDate deadlineTime) {
        super(description, isDone);
        this.deadlineTime = deadlineTime;
    }

    public Deadline(String description, LocalDate DeadlineTime) {
        this(description, false, DeadlineTime);
    }

    @Override
    public String getSaveMessage() {
        if (this.isDone) {
            return String.format("D / 1 / %s / %s", this.description, this.deadlineTime);
        } else {
            return String.format("D / 0 / %s / %s", this.description, this.deadlineTime);
        }
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return String.format("[D][X] %s (by: %s)", this.description, this.deadlineTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy")));
        } else {
            return String.format("[D][ ] %s (by: %s)", this.description, this.deadlineTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy")));
        }
    }
}