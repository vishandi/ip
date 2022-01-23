package duke;

import parser.Parser;
import storage.IStorage;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class Duke {
    public final IStorage storage;
    public TaskList taskList;
    public Ui ui;
    public Parser parser;

    public Duke(String saveFileDirectory, String saveFileName) throws DukeException {
        this.storage = new Storage(saveFileDirectory, saveFileName);
        this.taskList = new TaskList();
        this.ui = new Ui();
        this.parser = new Parser();
    }

    public Duke(IStorage storage) {
        this.storage = storage;
        this.taskList = new TaskList();
        this.ui = new Ui();
        this.parser = new Parser();
    }

    public static void main(String[] args) throws DukeException {
        try {
            Duke duke = new Duke("./data/", "TaskList.txt");
            duke.initialize();
            duke.run();
        } catch (DukeException d) {
            throw d;
        }
    }

    public void initialize() throws DukeException {
        this.ui.greet();
        this.taskList = storage.readFile();
        this.printTasks();
    }

    public void run() {
        while (true) {
            String userInput = this.ui.readUserInput();
            if (!processUserInput(userInput)) {
                break;
            }
        }
    }

    public void bye() {
        this.ui.bye();
    }

    public void printTasks() {
        this.ui.printMessage(this.taskList.toString());
    }

    public void writeTasks() throws DukeException {
        this.storage.writeToFile(this.taskList);
    }

    public boolean processUserInput(String userInput) {
        String[] userInputs = userInput.split(" ");
        String command = userInputs[0];
        try {
            switch (command) {
            case "bye":
                if (userInput.equals("bye")) {
                    bye();
                    return false;
                } else {
                    throw DukeException.DukeInvalidCommand();
                }
            case "list":
                if (userInput.equals("list")) {
                    printTasks();
                    return true;
                } else {
                    throw DukeException.DukeInvalidCommand();
                }
            case "mark":
                try {
                    int index = Integer.parseInt(userInput.substring(5)) - 1;
                    this.taskList.markTaskAsDone(index);
                    writeTasks();
                    return true;
                } catch (NumberFormatException e) {
                    throw DukeException.DukeInvalidIndex();
                } catch (IndexOutOfBoundsException e) {
                    throw DukeException.DukeInvalidIndex();
                } catch (DukeException d) {
                    throw d;
                }

            case "unmark":
                try {
                    int index = Integer.parseInt(userInput.substring(7)) - 1;
                    this.taskList.unmarkTaskAsDone(index);
                    writeTasks();
                    return true;
                } catch (NumberFormatException e) {
                    throw DukeException.DukeInvalidIndex();
                } catch (IndexOutOfBoundsException e) {
                    throw DukeException.DukeInvalidIndex();
                } catch (DukeException d) {
                    throw d;
                }

            case "delete":
                try {
                    int index = Integer.parseInt(userInput.substring(7)) - 1;
                    this.taskList.deleteTaskAtIndex(index);
                    return true;
                } catch (IndexOutOfBoundsException e) {
                    throw DukeException.DukeInvalidIndex();
                }

            default:
                try {
                    Task task = this.parser.parseFromUi(command, userInput);
                    this.taskList.addTask(task);
                    return true;
                } catch (DukeException d) {
                    throw d;
                }
             }
        } catch (DukeException d) {
             this.ui.printErrorMessage(d);
             return true;
        }
    }
}
