import java.util.Scanner;

public class Ui {
    private final Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public String readUserInput() {
        return this.sc.nextLine();
    }

    public void printErrorMessage(DukeException d) {
        System.out.println(d.getMessage());
    }

    public void greet() {
        System.out.println("Hello! I'm Dr.Kafka!");
        System.out.println("What can I do for you?");
    }

    public void bye() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
