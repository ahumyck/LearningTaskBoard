package com.evgeniy.task.board;

import com.evgeniy.files.FileDeleter;
import com.evgeniy.files.FilesManager;
import com.evgeniy.files.defaultDeleter;
import com.evgeniy.task.Task;
import com.evgeniy.task.creation.TaskCreationService;
import com.evgeniy.task.MockReward;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;


class TaskBoardTest {

    @Test
    void taskBoardCloneEquals() throws CloneNotSupportedException {
        Task task1 = TaskCreationService.getInstance().createTask("name1", "description1", new MockReward());
        Task task2 = TaskCreationService.getInstance().createTask("name2", "description2", new MockReward());
        Task task3 = TaskCreationService.getInstance().createTask("name3", "description3", new MockReward());
        Task task4 = TaskCreationService.getInstance().createTask("name4", "description4", new MockReward());
        TaskBoard taskBoard = new DefaultTaskBoard();

        taskBoard.addTask(task1);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task4);

        TaskBoard cloneTaskBoard = taskBoard.clone();
        Assertions.assertEquals(cloneTaskBoard, taskBoard);
        Assertions.assertNotSame(cloneTaskBoard, taskBoard);
    }

    @Test
    void taskBoardWriteRead() throws ClassNotFoundException {
        Task task1 = TaskCreationService.getInstance().createTask("name1", "description1", new MockReward());
        Task task2 = TaskCreationService.getInstance().createTask("name2", "description2", new MockReward());
        Task task3 = TaskCreationService.getInstance().createTask("name3", "description3", new MockReward());
        Task task4 = TaskCreationService.getInstance().createTask("name4", "description4", new MockReward());
        TaskBoard taskBoard = new DefaultTaskBoard();

        taskBoard.addTask(task1);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task4);
        FilesManager fileCommands = new FilesManager();
        FileDeleter deleter = new defaultDeleter();
        fileCommands.writeIntoFile("tmp.board", taskBoard);
        Optional<TaskBoard> readTaskBoard = fileCommands.readFromFile("tmp.board", TaskBoard.class);
        readTaskBoard.ifPresent(tasks -> Assertions.assertEquals(taskBoard, tasks));
        deleter.deleteFile("tmp.board");
        Optional<TaskBoard> readAgain = fileCommands.readFromFile("tmp.board", TaskBoard.class);
        Assertions.assertEquals(Optional.empty(), readAgain);
    }
}