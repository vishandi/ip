package parser;

import duke.Duke;
import duke.DukeException;
import ui.Ui;

import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Parser class.
 * To make sense what the user is commanding.
 */
public class Parser {
    private final Ui ui;
    private static final String[] COMMANDS = new String[] {"todo", "deadline", "event"};

    /**
     * Constructs Parser.
     */
    public Parser() {
        this.ui = new Ui();
    }

    /**
     * Parses the user input.
     *
     * @param command what command is the user inputting.
     * @param userInput the full user input.
     * @return Task corresponding to the user input.
     * @throws DukeException
     */
    public Task parseTaskFromUi(String command, String userInput) throws DukeException {
        assert command != null && userInput != null;
        switch (command) {
        case "todo":
            try {
                String description = userInput.split(" ", 2)[1];
                description = description.trim();
                if (description.equals("")) {
                    throw DukeException.DukeDescriptionEmpty();
                }
                return new Todo(description);
            } catch (IndexOutOfBoundsException e) {
                throw DukeException.DukeDescriptionEmpty();
            } catch (DukeException d) {
                throw DukeException.DukeDescriptionEmpty();
            }

        case "deadline":
            try {
                String[] descriptionAndTime = userInput.substring(9).split(" /by ");
                String description = descriptionAndTime[0].trim();
                if (description.equals("")) {
                    throw DukeException.DukeDescriptionEmpty();
                }
                LocalDate deadlineTime = parseDate(descriptionAndTime[1].trim());
                return new Deadline(description, deadlineTime);
            } catch (DukeException d) {
                throw d;
            } catch (Exception e) {
                throw DukeException.DukeInvalidCommand();
            }

        case "event":
            try {
                String[] descriptionAndTime = userInput.substring(6).split(" /at ");
                String description = descriptionAndTime[0].trim();
                if (description.equals("")) {
                    throw DukeException.DukeDescriptionEmpty();
                }
                LocalDate eventTime = parseDate(descriptionAndTime[1].trim());
                return new Event(description, eventTime);
            } catch (DukeException d) {
                throw d;
            } catch (Exception e) {
                throw DukeException.DukeInvalidCommand();
            }

        default:
            throw DukeException.DukeInvalidCommand();
        }
    }

    /**
     * Finds tasks that match the keyword.
     *
     * @param userInput the full user input.
     * @param tasks list of tasks that we want to match.
     * @return ArrayList\<Task\> of all tasks that match the keyword.
     * @throws DukeException if there is found any error.
     */
    public ArrayList<Task> findTasksByKeyword(String userInput, ArrayList<Task> tasks) throws DukeException {
        assert userInput != null && tasks != null;
        try {
            String keyword = userInput.split(" ", 2)[1];
            if (keyword.trim().length() == 0) {
                throw DukeException.DukeInvalidCommand();
            } else {
                keyword = keyword.trim();
            }
            String finalKeyword = keyword;
            Predicate<Task> matchingPredicate = task -> task.getDescription().contains(finalKeyword);
            List<Task> matchTasksList = tasks.stream().
                    filter(matchingPredicate).
                    collect(Collectors.toList());
            ArrayList<Task> matchTasks = new ArrayList<>(matchTasksList);
            return matchTasks;
        } catch (Exception e) {
            throw DukeException.DukeInvalidCommand();
        }
    }

    /**
     * Checks whether the task is a duplicate of any task in tasks.
     *
     * @param task the target task.
     * @param tasks the lookup list of tasks.
     * @return true if the task is a duplicate, false otherwise.
     */
    public boolean isDuplicate(Task task, ArrayList<Task> tasks) {
        Predicate<Task> duplicatePredicate = t -> t.equals(task);
        return tasks.stream().
                anyMatch(duplicatePredicate);
    }

    /**
     * Parses the date that the user means.
     *
     * @param date date in String representation
     * @return LocalDate if the String is compatible with one of the available patterns.
     * @throws DukeException if the String isn't compatible with any.
     */
    public LocalDate parseDate(String date) throws DukeException {
        System.out.println(date);
        String[] patterns = {"yyyy-MM-dd", "yyyy/MM/dd", "yyyy MMM dd", "dd MMM yyyy", "dd-MM-yyyy", "dd/MM/yyyy"};
        for (String pattern : patterns) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                return LocalDate.parse(date, formatter);
            } catch (Exception e) {

            }
        }
        throw DukeException.DukeInvalidDateFormat();
    }
}
