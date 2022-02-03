package parser;

import duke.Duke;
import duke.DukeException;
import ui.Ui;

import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Parser class.
 * To make sense what the user is commanding.
 */
public class Parser {
    private final Ui ui;
    private static final String[] COMMANDS = new String[] {"todo", "deadline", "event"};

    /**
     * Constructor for Parser.
     */
    public Parser() {
        this.ui = new Ui();
    }

    /**
     * Parses the user input.
     * @param command what command is the user inputting.
     * @param userInput the full user input.
     * @return Task corresponding to the user input.
     * @throws DukeException
     */
    public Task parseFromUi(String command, String userInput) throws DukeException {
        switch (command) {
        case "todo":
            try {
                String description = userInput.split(" ", 2)[1];
                description = description.trim();
                if (description.equals("")) {
                    throw DukeException.DukeTodoEmpty();
                }
                return new Todo(description);
            } catch (IndexOutOfBoundsException e) {
                throw DukeException.DukeTodoEmpty();
            } catch (DukeException d) {
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

    /**
     * Finds tasks that match the keyword.
     * @param userInput the full user input.
     * @param tasks list of tasks that we want to match.
     * @return ArrayList\<Task\> of all tasks that match the keyword.
     * @throws DukeException
     */
    public ArrayList<Task> findTasksByKeyword(String userInput, ArrayList<Task> tasks) throws DukeException {
        try {
            String keyword = userInput.split(" ", 2)[1];
            if (keyword.trim().length() == 0) {
                throw DukeException.DukeInvalidCommand();
            } else {
                keyword = keyword.trim();
            }
            ArrayList<Task> matchTasks = new ArrayList<>();
            for (Task task : tasks) {
                if (task.getDescription().contains(keyword)) {
                    matchTasks.add(task);
                }
            }
            return matchTasks;
        } catch (Exception e) {
            throw DukeException.DukeInvalidCommand();
        }
    }
}
