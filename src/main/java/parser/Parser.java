package duke;

import java.time.LocalDate;

public class Parser {
    private final Ui ui;
    private static final String[] COMMANDS = new String[] {"todo", "deadline", "event"};

    public Parser() {
        this.ui = new Ui();
    }

    public Task parseFromUi(String command, String userInput) throws DukeException {
        switch (command) {
        case "todo":
            try {
                String description = userInput.split(" ", 2)[1];
                return new Todo(description);
            } catch (IndexOutOfBoundsException e) {
                throw DukeException.DukeTodoEmpty();
            }

        case "deadline":
            try {
                String[] descriptionAndTime = userInput.substring(9).split(" /by ");
                String description = descriptionAndTime[0];
                LocalDate deadlineTime = LocalDate.parse(descriptionAndTime[1].trim());
                return new Deadline(description, deadlineTime);
            } catch (Exception e) {
                throw DukeException.DukeInvalidCommand();
            }

        case "event":
            try {
                String[] descriptionAndTime = userInput.substring(6).split(" /at ");
                String description = descriptionAndTime[0];
                LocalDate eventTime = LocalDate.parse(descriptionAndTime[1].trim());
                return new Event(description, eventTime);
            } catch (Exception e) {
                throw DukeException.DukeInvalidCommand();
            }

        default:
            throw DukeException.DukeInvalidCommand();
        }
    }

}
