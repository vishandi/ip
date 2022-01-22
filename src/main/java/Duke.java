import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    private static final String[] COMMANDS = new String[] {"mark", "unmark", "todo", "deadline", "event", "delete"};
    public static String SAVE_FILE_PATH = "./data/";
    public static String SAVE_FILE_NAME = "TaskList.txt";
    private static final TaskList TASK_LIST = new TaskList(SAVE_FILE_PATH, SAVE_FILE_NAME);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        initialize();

        while (true) {
            String userInput = sc.nextLine();

            if (userInput.equals("bye")) {
                bye();
                break;
            }
            processUserInput(userInput);
        }
    }

    public static void initialize() {
        System.out.println("Hello! I'm Dr.Kafka!");
        System.out.println("What can I do for you?");
        TASK_LIST.readFile();
    }

    public static void bye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void processUserInput(String userInput) {
        if (userInput.equals("list")) {
            System.out.println(TASK_LIST);
        } else {
            String[] userInputs = userInput.split(" ");
            String command = userInputs[0];
            try {
                if (Arrays.stream(COMMANDS).noneMatch(command::equals)) {
                    throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :(");
                }
                switch (command) {
                case "mark":
                    try {
                        int index = Integer.parseInt(userInput.substring(5)) - 1;
                        TASK_LIST.markTaskAsDone(index);
                    } catch (NumberFormatException e) {
                        throw new DukeException("Sorry, I don't understand which task should I mark as done :(");
                    } catch (IndexOutOfBoundsException e) {
                        int index = Integer.parseInt(userInput.substring(5)) - 1;
                        throw new DukeException(String.format("Sorry, there is no no.%d task", index));
                    }
                    break;

                case "unmark":
                    try {
                        int index = Integer.parseInt(userInput.substring(7)) - 1;
                        TASK_LIST.unmarkTaskAsDone(index);
                    } catch (NumberFormatException e) {
                        throw new DukeException("Sorry, I don't understand which task should I unmark as done :(");
                    } catch (IndexOutOfBoundsException e) {
                        int index = Integer.parseInt(userInput.substring(7)) - 1;
                        throw new DukeException(String.format("Sorry, there is no no.%d task", index));
                    }
                    break;

                case "delete":
                    try {
                        int index = Integer.parseInt(userInput.substring(7)) - 1;
                        TASK_LIST.deleteTaskAtIndex(index);
                    } catch (NumberFormatException e) {
                        throw new DukeException("Sorry, I don't understand which task should I delete :(");
                    } catch (IndexOutOfBoundsException e) {
                        int index = Integer.parseInt(userInput.substring(7)) - 1;
                        throw new DukeException(String.format("Sorry, there is no no.%d task", index));
                    }
                    break;

                case "todo":
                    try {
                        String description = userInput.split(" ", 2)[1];
                        TASK_LIST.addTask(new Todo(description));
                    } catch (IndexOutOfBoundsException e) {
                        throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
                    }
                    break;

                case "deadline":
                    try {
                        String[] descriptionAndTime = userInput.substring(9).split(" /by ");
                        String description = descriptionAndTime[0];
                        String deadlineTime = descriptionAndTime[1];
                        TASK_LIST.addTask(new Deadline(description, deadlineTime));
                    } catch (Exception e) {
                        throw new DukeException("OOPS!!! Your command is incomplete :(");
                    }
                    break;

                case "event":
                    try {
                        String[] descriptionAndTime = userInput.substring(6).split(" /at ");
                        String description = descriptionAndTime[0];
                        String eventTime = descriptionAndTime[1];
                        TASK_LIST.addTask(new Event(description, eventTime));
                    } catch (Exception e) {
                        throw new DukeException("OOPS!!! Your command is incomplete :(");
                    }
                    break;
                }
            } catch (DukeException d) {
                System.out.println(d.getMessage());
            }
        }
    }
}
