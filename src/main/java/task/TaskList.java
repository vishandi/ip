package task;

import java.util.ArrayList;

/**
 * Class to store tasks in a list.
 */
public class TaskList {
    private static final String MARK_AS_DONE = "Great job Master! You have finished this task! " +
            "Hendri has marked this task as done:";
    private static final String UNMARK_AS_DONE = "Are you not doing well Master? " +
            "Why are you unmarking this task:";
    private static final String DELETE_TASK = "Are you not satisfied with Hendri's service Master :( ? " +
            "Okay, Hendri has removed this task:";
    private static final String ADD_TASK = "Yey! Hendri got another task to handle for Master! " +
            "Okay, Hendri has added this task:";
    private ArrayList<Task> tasks;

    /**
     * Constructs TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Gets all tasks that are stored in this instance.
     *
     * @return ArrayList of tasks.
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Gets task at index.
     *
     * @param index index to retrieve.
     * @return task at specified index.
     * @throws IndexOutOfBoundsException
     */
    public Task getTaskAtIndex(int index) throws IndexOutOfBoundsException {
        return this.tasks.get(index);
    }

    /**
     * Marks task as done.
     *
     * @param index index of task to be marked as done.
     * @return response message after this task is marked.
     * @throws IndexOutOfBoundsException
     */
    public String markTaskAsDone(int index) throws IndexOutOfBoundsException {
        this.tasks.get(index).markAsDone();
        return String.format("%s \n %s",
                MARK_AS_DONE,
                tasks.get(index));
    }

    /**
     * Marks task as not done.
     *
     * @param index index of task to be unmarked as done.
     * @return response message after this task is unmarked.
     * @throws IndexOutOfBoundsException
     */
    public String unmarkTaskAsDone(int index) throws IndexOutOfBoundsException {
        this.tasks.get(index).unmarkAsDone();
        return String.format("%s \n %s",
                UNMARK_AS_DONE,
                tasks.get(index));
    }

    /**
     * Deletes task from the list.
     *
     * @param index index of task to be deleted.
     * @return response message after this task is deleted.
     * @throws IndexOutOfBoundsException
     */
    public String deleteTaskAtIndex(int index) throws IndexOutOfBoundsException {
        Task deleted = this.tasks.get(index);
        this.tasks.remove(index);
        return String.format("%s \n %s \n %s",
                DELETE_TASK,
                deleted.toString(),
                String.format("Now Master has %s tasks in the list.", this.tasks.size()));
    }

    /**
     * Adds a new task to the list.
     *
     * @param task task to be added.
     * @return response message after the task is added.
     */
    public String addTask(Task task) {
        this.tasks.add(task);
        return String.format("%s \n%s \n%s",
                ADD_TASK,
                tasks.get(tasks.size() - 1).toString(),
                String.format("Now Master has %s tasks in the list.", tasks.size()));
    }

    /**
     * Adds specified task to the list, but returns no message.
     * @param task
     */
    public void addTaskNoMessage(Task task) {
        this.tasks.add(task);
    }

    @Override
    public String toString() {
        if (this.tasks.isEmpty()) {
            return "Hendri really wants to help, but Master doesn't have any task at the moment.";
        } else {
            StringBuilder msg = new StringBuilder();
            msg.append("Here are Master's current tasks:");
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
