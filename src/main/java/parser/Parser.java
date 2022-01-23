package parser;

import duke.DukeException;
import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;
import ui.Ui;

import java.time.LocalDate;
import java.util.ArrayList;

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