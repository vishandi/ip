package duke;

public class Todo extends Task {

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    public Todo(String description) {
        this(description, false);
    }

    @Override
    public String getSaveMessage() {
        if (this.isDone) {
            return String.format("T / 1 / %s", this.description);
        } else {
            return String.format("T / 0 / %s", this.description);
        }
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return String.format("[T][X] %s", this.description);
        } else {
            return String.format("[T][ ] %s", this.description);
        }
    }
}