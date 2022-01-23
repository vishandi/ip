package task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate eventTime;

    /**
     * Constructor for Event.
     * @param description
     * @param isDone
     * @param eventTime
     */
    public Event(String description, boolean isDone, LocalDate eventTime) {
        super(description, isDone);
        this.eventTime = eventTime;
    }

    /**
     * Another constructor for Event.
     * @param description
     * @param eventTime
     */
    public Event(String description, LocalDate eventTime) {
        this(description, false, eventTime);
    }

    /**
     * Get the saved message corresponding to this task.
     * @return save message for the task.
     */
    @Override
    public String getSaveMessage() {
        if (this.isDone) {
            return String.format("E / 1 / %s / %s", this.description, this.eventTime);
        } else {
            return String.format("E / 0 / %s / %s", this.description, this.eventTime);
        }
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return String.format("[E][X] %s (at: %s)", this.description, this.eventTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy")));
        } else {
            return String.format("[E][ ] %s (at: %s)", this.description, this.eventTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy")));
        }
    }
}