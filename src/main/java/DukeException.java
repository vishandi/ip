public class DukeException extends Exception {
    public DukeException(String msg) {
        super(msg);
    }

    public static DukeException DukeIOException() {
        return new DukeException("cannot handle the file, sorry :(");
    }

    public static DukeException DukeFileNotFoundException() {
        return new DukeException("No file found :(");
    }

    public static DukeException DukeFileIncomplete() {
        return new DukeException("Please check your file, some of its lines are corrupted :(");
    }

    public static DukeException DukeInvalidCommand() {
        return new DukeException("Sorry, I don't understand your command :(");
    }

    public static DukeException DukeInvalidIndex() {
        return new DukeException("Sorry, I don't understand which task you're talking about :(");
    }

    public static DukeException DukeTodoEmpty() {
        return new DukeException("OOPS!!! The description of a todo cannot be empty.");
    }
}