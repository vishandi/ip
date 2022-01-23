package task;

import task.Task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructor for TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Get all tasks that is stored in this instance.
     * @return ArrayList of tasks.
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Getter function for tasks at index.
     * @param index
     * @return task at specified index
     * @throws IndexOutOfBoundsException
     */
    public Task getTaskAtIndex(int index) throws IndexOutOfBoundsException {
        return this.tasks.get(index);
    }

    /**
     * Marks task at specified index as done.
     * @param index
     * @throws IndexOutOfBoundsException
     */
    public void markTaskAsDone(int index) throws IndexOutOfBoundsException {
        this.tasks.get(index).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(tasks.get(index));
    }

    /**
     * Unmarks task at specified index as done.
     * @param index
     * @throws IndexOutOfBoundsException
     */
    public void unmarkTaskAsDone(int index) throws IndexOutOfBoundsException {
        this.tasks.get(index).unmarkAsDone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(tasks.get(index));
    }

    /**
     * Deletes task at specified index.
     * @param index
     * @throws IndexOutOfBoundsException
     */
    public void deleteTaskAtIndex(int index) throws IndexOutOfBoundsException {
        Task deleted = this.tasks.get(index);
        System.out.println("Noted. I've removed this task:");
        System.out.println(deleted);
        this.tasks.remove(index);
        System.out.printf("Now you have %s tasks in the list.\n", this.tasks.size());
    }

    /**
     * Add specified task to the list.
     * @param task
     */
    public void addTask(Task task) {
        this.tasks.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.get(tasks.size() - 1));
        System.out.printf("Now you have %s tasks in the list.\n", tasks.size());
    }

    /**
     * Add specified task to the list, but prints no message.
     * @param task
     */
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
