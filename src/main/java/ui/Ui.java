package ui;

import duke.DukeException;
import task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private final Scanner sc;

    /**
     * Constructor for Ui.
     */
    public Ui() {
        sc = new Scanner(System.in);
    }

    /**
     * Reads user input and returning the message.
     * @return String
     */
    public String readUserInput() {
        return this.sc.nextLine();
    }

    /**
     * Prints error messages.
     * @param d
     */
    public String getErrorMessage(DukeException d) {
        return d.getMessage();
    }

    public String printMatchTasks(ArrayList<Task> matchTasks) {
        if (matchTasks.isEmpty()) {
            return "No task matches your keyword :(";
        } else {
            StringBuilder response = new StringBuilder("Here are the matching tasks in your list:\n");
            for (int i = 0; i < matchTasks.size(); i++) {
                response.append(String.valueOf(i + 1));
                response.append(". ");
                response.append(matchTasks.get(i).toString());
                response.append("\n");
            }
            return response.toString();
        }
    }
}
