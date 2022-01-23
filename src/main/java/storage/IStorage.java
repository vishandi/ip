package storage;

import duke.DukeException;
import task.Task;
import task.TaskList;

public interface IStorage {
    /**
     * Reads file from the path.
     * @return TaskList
     * @throws DukeException
     */
    TaskList readFile() throws DukeException;

    /**
     * Writes the tasks to the file on the path.
     * @param taskList
     * @throws DukeException
     */
    void writeToFile(TaskList taskList) throws DukeException;

    /**
     * Processes lines from the file.
     * @param line
     * @return Task
     * @throws DukeException
     */
    Task processLine(String line) throws DukeException;
}
