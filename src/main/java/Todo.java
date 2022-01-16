public class Todo extends Task {

    private Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    public Todo(String description) {
        this(description, false);
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