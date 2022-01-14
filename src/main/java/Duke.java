import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] itemList = new String[100];
        int numItem = 0;
        System.out.println("Hello! I'm Dr.Kafka!");
        System.out.println("What can I do for you?");
        while (true) {
            String userInput = sc.nextLine();
            if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (userInput.equals("list")) {
                for (int i = 0; i < numItem; i++) {
                    System.out.print(i + 1);
                    System.out.print(". ");
                    System.out.println(itemList[i]);
                }
            } else {
                itemList[numItem] = userInput;
                numItem += 1;
                System.out.print("added: ");
                System.out.println(userInput);
            }
        }
    }
}
