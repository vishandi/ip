public class Task {
    protected String description;
    protected boolean isDone;

    private Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public Task(String description) {
        this(description, false);
    }

    public String getStatusIcon() {
        return (this.isDone ? "X" : " ");
    }

    public Task markAsDone() {
        return new Task(this.description, true);
    }

    public Task unmarkAsDone() {
        return new Task(this.description, false);
    }

    public String getString() {
        if (this.isDone) {
            return "[X] " + this.description;
        } else {
            return "[ ] " + this.description;
        }
    }
}
