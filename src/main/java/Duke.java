import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static String[] commands = new String[] {"mark", "unmark", "todo", "deadline", "event", "delete"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello! I'm Dr.Kafka!");
        System.out.println("What can I do for you?");

        while (true) {
            String userInput = sc.nextLine();

            if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            processUserInput(userInput);
        }
    }

    public static void addingTaskMessage() {
        System.out.println("Got it. I've added this task:");
        System.out.println(taskList.get(taskList.size() - 1));
        System.out.printf("Now you have %s tasks in the list.\n", taskList.size());
    }
    public static void processUserInput(String userInput) {
         if (userInput.equals("list")) {
            if (taskList.isEmpty()) {
                System.out.println("You don't have any task at the moment.");
            } else {
                System.out.println("Here are your current tasks:");
                for (int i = 0; i < taskList.size(); i++) {
                    System.out.print(i + 1);
                    System.out.print(".");
                    System.out.println(taskList.get(i));
                }
            }
        } else {
             String[] userInputs = userInput.split(" ");
             String command = userInputs[0];
             try {
                 if (!Arrays.stream(commands).anyMatch(command::equals)) {
                     throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :(");
                 }

                 switch (command) {
                     case "mark":
                         try {
                             int index = Integer.parseInt(userInput.substring(5)) - 1;
                             taskList.get(index).markAsDone();
                             System.out.println("Nice! I've marked this task as done:");
                             System.out.println(taskList.get(index));
                         } catch (Exception e) {
                             throw new DukeException("Sorry, I don't understand which task should I mark as done :(");
                         }
                         break;

                     case "unmark":
                         try {
                             int index = Integer.parseInt(userInput.substring(7)) - 1;
                             taskList.get(index).unmarkAsDone();
                             System.out.println("OK, I've marked this task as not done yet:");
                             System.out.println(taskList.get(index));
                         } catch (Exception e) {
                             throw new DukeException("Sorry, I don't understand which task should I unmark as done :(");
                         }
                         break;

                     case "delete":
                         try {
                             int index = Integer.parseInt(userInput.substring(7)) - 1;
                             Task deleted = taskList.get(index);
                             System.out.println("Noted. I've removed this task:");
                             System.out.println(deleted);
                             taskList.remove(index);
                             System.out.printf("Now you have %s tasks in the list.\n", taskList.size());
                         } catch (Exception e) {
                             throw new DukeException("Sorry, I don't understand which task should I delete :(");
                         }
                         break;

                     case "todo":
                         try {
                             String description = userInput.split(" ", 2)[1];
                             taskList.add(new Todo(description));
                             addingTaskMessage();
                         } catch (Exception e) {
                             throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
                         }
                         break;

                     case "deadline":
                         try {
                             String[] descriptionAndTime = userInput.substring(9).split(" /by ");
                             String description = descriptionAndTime[0];
                             String deadlineTime = descriptionAndTime[1];
                             taskList.add(new Deadline(description, deadlineTime));
                             addingTaskMessage();
                         } catch (Exception e) {
                             throw new DukeException("When is the due date of this deadline?");
                         }
                         break;

                     case "event":
                         try {
                             String[] descriptionAndTime = userInput.substring(6).split(" /at ");
                             String description = descriptionAndTime[0];
                             String eventTime = descriptionAndTime[1];
                             taskList.add(new Event(description, eventTime));
                             addingTaskMessage();
                         } catch (Exception e) {
                             throw new DukeException("What time is this event gonna be?");
                         }
                         break;
                 }
             } catch (DukeException d) {
                 System.out.println(d.getMessage());
             }
         }
    }
}
