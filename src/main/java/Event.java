public class Event extends Task {
    protected String eventTime;

    public Event(String description, boolean isDone, String eventTime) {
        super(description, isDone);
        this.eventTime = eventTime;
    }

    public Event(String description, String eventTime) {
        this(description, false, eventTime);
    }

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
            return String.format("[E][X] %s (at: %s)", this.description, this.eventTime);
        } else {
            return String.format("[E][ ] %s (at: %s)", this.description, this.eventTime);
        }
    }
}