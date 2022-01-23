package storage;

import duke.DukeException;
import task.Task;
import task.TaskList;

public interface IStorage {
    TaskList readFile() throws DukeException;
    void writeToFile(TaskList taskList) throws DukeException;
    Task processLine(String line) throws DukeException;
}
