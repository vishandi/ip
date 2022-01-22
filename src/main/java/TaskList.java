import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
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
}
