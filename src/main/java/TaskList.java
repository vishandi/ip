import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    private ArrayList<Task> taskList;
    private final String saveFilePath;

    public TaskList(String saveFileDirectory, String saveFileName) {
        this.taskList = new ArrayList<>();
        this.saveFilePath = saveFileDirectory + saveFileName;

        File fileDirectory = new File(saveFileDirectory);
        if (!fileDirectory.exists()) {
            fileDirectory.mkdir();
        }

        File saveFile = new File(this.saveFilePath);
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
            } catch (IOException e) {
                System.out.println("I cannot handle the file, sorry :(" + e.getMessage());
            }
        }

        readFile();
    }

    public void readFile() {
        this.taskList = new ArrayList<>();
        File file = new File(saveFilePath);

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                this.taskList.add(processLine(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found :(");
        } catch (DukeException d) {
            System.out.println(d.getMessage());
            this.taskList = new ArrayList<>();
        }
    }

    public void writeToFile() {
        StringBuilder msg = new StringBuilder();
        for (Task task : taskList) {
            msg.append(task.getSaveMessage()).append("\n");
        }
        try {
            FileWriter fw = new FileWriter(saveFilePath);
            fw.write(msg.toString());
            fw.close();
        } catch (IOException e) {
            System.out.println("I cannot handle the file, sorry :(");
        }
    }

    public Task processLine(String line) throws DukeException { //can add exception when handling the lines for possible corrupted file
        String[] description = line.split(" / ");
        switch (description[0]) {
        case "T":
            if (description[1].equals("1")) {
                return new Todo(description[2], true);
            } else {
                return new Todo(description[2], false);
            }
        case "D":
            if (description[1].equals("1")) {
                return new Deadline(description[2], true, LocalDate.parse(description[3]));
            } else {
                return new Deadline(description[2], false, LocalDate.parse(description[3]));
            }
        case "E":
            if (description[1].equals("1")) {
                return new Event(description[2], true, LocalDate.parse(description[3]));
            } else {
                return new Event(description[2], false, LocalDate.parse(description[3]));
            }
        default:
            throw new DukeException("Please check your file, some of its lines are corrupted :(");
        }
    }

    public void markTaskAsDone(int index) throws IndexOutOfBoundsException {
        this.taskList.get(index).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskList.get(index));
        writeToFile();
    }

    public void unmarkTaskAsDone(int index) throws IndexOutOfBoundsException {
        this.taskList.get(index).unmarkAsDone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(taskList.get(index));
        writeToFile();
    }

    public void deleteTaskAtIndex(int index) throws IndexOutOfBoundsException {
        Task deleted = this.taskList.get(index);
        System.out.println("Noted. I've removed this task:");
        System.out.println(deleted);
        this.taskList.remove(index);
        System.out.printf("Now you have %s tasks in the list.\n", this.taskList.size());
        writeToFile();
    }

    public void addTask(Task task) {
        this.taskList.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println(taskList.get(taskList.size() - 1));
        System.out.printf("Now you have %s tasks in the list.\n", taskList.size());
        writeToFile();
    }

    @Override
    public String toString() {
        if (this.taskList.isEmpty()) {
            return "You don't have any task at the moment.";
        } else {
            StringBuilder msg = new StringBuilder();
            msg.append("Here are your current tasks:\n");
            for (int i = 0; i < this.taskList.size(); i++) {
                msg.append(i + 1);
                msg.append(". ");
                msg.append(this.taskList.get(i).toString());
            }
            return msg.toString();
        }
    }
}
