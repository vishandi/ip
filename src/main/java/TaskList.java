import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return this.taskList;
    }

    public void markTaskAsDone(int index) throws IndexOutOfBoundsException {
        this.taskList.get(index).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskList.get(index));
    }

    public void unmarkTaskAsDone(int index) throws IndexOutOfBoundsException {
        this.taskList.get(index).unmarkAsDone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(taskList.get(index));
    }

    public void deleteTaskAtIndex(int index) throws IndexOutOfBoundsException {
        Task deleted = this.taskList.get(index);
        System.out.println("Noted. I've removed this task:");
        System.out.println(deleted);
        this.taskList.remove(index);
        System.out.printf("Now you have %s tasks in the list.\n", this.taskList.size());
    }

    public void addTask(Task task) {
        this.taskList.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println(taskList.get(taskList.size() - 1));
        System.out.printf("Now you have %s tasks in the list.\n", taskList.size());
    }

    public void addTaskNoMessage(Task task) {
        this.taskList.add(task);
    }

    @Override
    public String toString() {
        if (this.taskList.isEmpty()) {
            return "You don't have any task at the moment.";
        } else {
            StringBuilder msg = new StringBuilder();
            msg.append("Here are your current tasks:");
            for (int i = 0; i < this.taskList.size(); i++) {
                msg.append("\n");
                msg.append(i + 1);
                msg.append(". ");
                msg.append(this.taskList.get(i).toString());
            }
            return msg.toString();
        }
    }
}
