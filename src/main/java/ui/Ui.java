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
     * Prints message.
     * @param msg
     */
    public void printMessage(String msg) {
        System.out.println(msg);
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
    public void printErrorMessage(DukeException d) {
        System.out.println(d.getMessage());
    }

    public void printMatchTasks(ArrayList<Task> matchTasks) {
        if (matchTasks.isEmpty()) {
            System.out.println("No task matches your keyword :(");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < matchTasks.size(); i++) {
                System.out.print(i + 1);
                System.out.print(". ");
                System.out.println(matchTasks.get(i).toString());
            }
        }
    }

    /**
     * Greets the user.
     */
    public void greet() {
        System.out.println("Hello! I'm Dr.Kafka!");
        System.out.println("What can I do for you?");
    }

    /**
     * Says goodbye to the user.
     */
    public void sayGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
