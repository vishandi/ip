public class Event extends Task {
    protected String eventTime;

    private Event(String description, boolean isDone, String eventTime) {
        super(description, isDone);
        this.eventTime = eventTime;
    }

    public Event(String description, String eventTime) {
        this(description, false, eventTime);
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return String.format("[E] [X] %s (at: %s)", this.description, this.eventTime);
        } else {
            return String.format("[E] [ ] %s (at: %s)", this.description, this.eventTime);
        }
    }
}
