package task;

import task.Task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public Task getTaskAtIndex(int index) throws IndexOutOfBoundsException {
        return this.taskList.get(index);
    }

    public void markTaskAsDone(int index) throws IndexOutOfBoundsException {
        this.tasks.get(index).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(tasks.get(index));
    }

    public void unmarkTaskAsDone(int index) throws IndexOutOfBoundsException {
        this.tasks.get(index).unmarkAsDone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(tasks.get(index));
    }

    public void deleteTaskAtIndex(int index) throws IndexOutOfBoundsException {
        Task deleted = this.tasks.get(index);
        System.out.println("Noted. I've removed this task:");
        System.out.println(deleted);
        this.tasks.remove(index);
        System.out.printf("Now you have %s tasks in the list.\n", this.tasks.size());
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.get(tasks.size() - 1));
        System.out.printf("Now you have %s tasks in the list.\n", tasks.size());
    }

    public void addTaskNoMessage(Task task) {
        this.tasks.add(task);
    }

    @Override
    public String toString() {
        if (this.tasks.isEmpty()) {
            return "You don't have any task at the moment.";
        } else {
            StringBuilder msg = new StringBuilder();
            msg.append("Here are your current tasks:");
            for (int i = 0; i < this.tasks.size(); i++) {
                msg.append("\n");
                msg.append(i + 1);
                msg.append(". ");
                msg.append(this.tasks.get(i)
                        .toString());
            }
            return msg.toString();
        }
    }
}
