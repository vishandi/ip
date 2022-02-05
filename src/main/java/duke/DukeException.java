package duke;

/**
 * Class for DukeException, exceptions used in this project.
 */
public class DukeException extends Exception {
    private static final String IO_EXCEPTION_MSG = "cannot handle the file, sorry :(";
    private static final String FILE_NOT_FOUND_EXCEPTION_MSG = "No file found :(";
    private static final String FILE_INCOMPLETE_MSG =
            "Please check your file, some of its lines are corrupted :(";
    private static final String INVALID_COMMAND_MSG = "Sorry, I don't understand your command :(";
    private static final String INVALID_INDEX_MSG = "Sorry, I don't understand which task you're talking about :(";
    private static final String TODO_EMPTY_MSG = "OOPS!!! The description of a todo cannot be empty.";

    /**
     * Constructor for DukeException.
     * @param msg message that will be printed when the exception is thrown.
     */
    public DukeException(String msg) {
        super(msg);
    }

    /**
     * A type of DukeException to handle IOException.
     * @return
     */
    public static DukeException DukeIOException() {
        return new DukeException(IO_EXCEPTION_MSG);
    }

    /**
     * A type of DukeException to handle FileNotFoundException.
     * @return
     */
    public static DukeException DukeFileNotFoundException() {
        return new DukeException(FILE_NOT_FOUND_EXCEPTION_MSG);
    }

    /**
     * A type of DukeException to handle Incomplete lines on the file.
     * @return
     */
    public static DukeException DukeFileIncomplete() {
        return new DukeException(FILE_INCOMPLETE_MSG);
    }

    /**
     * A type of DukeException to handle invalid command.
     * @return
     */
    public static DukeException DukeInvalidCommand() {
        return new DukeException(INVALID_COMMAND_MSG);
    }

    /**
     * A type of DukeException to handle IndexOutOfBoundException.
     * @return
     */
    public static DukeException DukeInvalidIndex() {
        return new DukeException(INVALID_INDEX_MSG);
    }

    /**
     * A type of DukeException to handle Invalid todo command.
     * @return
     */
    public static DukeException DukeTodoEmpty() {
        return new DukeException(TODO_EMPTY_MSG);
    }
}