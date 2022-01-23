package duke;

public class DukeException extends Exception {

    /**
     * Constructor for DukeException.
     * @param msg
     */
    public DukeException(String msg) {
        super(msg);
    }

    /**
     * A type of DukeException to handle IOException.
     * @return
     */
    public static DukeException DukeIOException() {
        return new DukeException("cannot handle the file, sorry :(");
    }

    /**
     * A type of DukeException to handle FileNotFoundException.
     * @return
     */
    public static DukeException DukeFileNotFoundException() {
        return new DukeException("No file found :(");
    }

    /**
     * A type of DukeException to handle Incomplete lines on the file.
     * @return
     */
    public static DukeException DukeFileIncomplete() {
        return new DukeException("Please check your file, some of its lines are corrupted :(");
    }

    /**
     * A type of DukeException to handle invalid command.
     * @return
     */
    public static DukeException DukeInvalidCommand() {
        return new DukeException("Sorry, I don't understand your command :(");
    }

    /**
     * A type of DukeException to handle IndexOutOfBoundException.
     * @return
     */
    public static DukeException DukeInvalidIndex() {
        return new DukeException("Sorry, I don't understand which task you're talking about :(");
    }

    /**
     * A type of DukeException to handle Invalid todo command.
     * @return
     */
    public static DukeException DukeTodoEmpty() {
        return new DukeException("OOPS!!! The description of a todo cannot be empty.");
    }
}