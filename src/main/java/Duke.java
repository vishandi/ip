import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task[] taskList = new Task[100];
        int numTask = 0;

        System.out.println("Hello! I'm Dr.Kafka!");
        System.out.println("What can I do for you?");

        while (true) {
            String userInput = sc.nextLine();
            if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (userInput.equals("list")) {
                for (int i = 0; i < numTask; i++) {
                    System.out.print(i + 1);
                    System.out.print(".");
                    System.out.println(taskList[i].getString());
                }
            } else if (userInput.substring(0, 4).equals("mark")) {
                int index = Integer.parseInt(userInput.substring(5)) - 1;
                taskList[index] = taskList[index].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(taskList[index].getString());
            } else if (userInput.substring(0, 6).equals("unmark")) {
                int index = Integer.parseInt(userInput.substring(7)) - 1;
                taskList[index] = taskList[index].unmarkAsDone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(taskList[index].getString());
            } else {
                taskList[numTask] = new Task(userInput);
                numTask += 1;
                System.out.print("added: ");
                System.out.println(userInput);
            }
        }
    }
}
