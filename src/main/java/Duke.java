import java.util.Scanner;
public class Duke {
    private static Task[] taskList = new Task[100];
    private static int numTask = 0;
    
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

    public static void processUserInput(String userInput) {
         if (userInput.equals("list")) {
            for (int i = 0; i < numTask; i++) {
                System.out.print(i + 1);
                System.out.print(".");
                System.out.println(taskList[i]);
            }
        } else if (userInput.substring(0, 4).equals("mark")) {
            int index = Integer.parseInt(userInput.substring(5)) - 1;
            taskList[index].markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(taskList[index]);
        } else if (userInput.substring(0, 6).equals("unmark")) {
            int index = Integer.parseInt(userInput.substring(7)) - 1;
            taskList[index].unmarkAsDone();
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println(taskList[index]);
        } else {
            if (userInput.substring(0, 4).equals("todo")) {
                String description = userInput.split(" ", 2)[1];
                taskList[numTask] = new Todo(description);
                numTask += 1;
            } else if (userInput.substring(0, 8).equals("deadline")) {
                String[] descriptionAndTime = userInput.substring(9).split(" /by ");
                String description = descriptionAndTime[0];
                String deadlineTime = descriptionAndTime[1];
                taskList[numTask] = new Deadline(description, deadlineTime);
                numTask += 1;
            } else if (userInput.substring(0, 5).equals("event")) {
                String[] descriptionAndTime = userInput.substring(6).split(" /at ");
                String description = descriptionAndTime[0];
                String eventTime = descriptionAndTime[1];
                taskList[numTask] = new Event(description, eventTime);
                numTask += 1;
            }
            System.out.println("Got it. I've added this task:");
            System.out.println(taskList[numTask - 1]);
            System.out.printf("Now you have %s tasks in the list.\n", numTask);
        }
    }
}
