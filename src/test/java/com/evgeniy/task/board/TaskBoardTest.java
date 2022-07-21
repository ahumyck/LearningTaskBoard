package com.evgeniy.task.board;

import com.evgeniy.files.WorkWithFiles;
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
    void taskBoardWriteRead() throws IOException, ClassNotFoundException {
        Task task1 = TaskCreationService.getInstance().createTask("name1", "description1", new MockReward());
        Task task2 = TaskCreationService.getInstance().createTask("name2", "description2", new MockReward());
        Task task3 = TaskCreationService.getInstance().createTask("name3", "description3", new MockReward());
        Task task4 = TaskCreationService.getInstance().createTask("name4", "description4", new MockReward());
        TaskBoard taskBoard = new DefaultTaskBoard();

        taskBoard.addTask(task1);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task4);
        WorkWithFiles fileCommands = new WorkWithFiles();
        fileCommands.writeTaskBoardIntoFile(taskBoard, "tmp.board");
        Optional<TaskBoard> readTaskBoard = fileCommands.readTaskBoardFromFile("tmp.board");
        Assertions.assertEquals(taskBoard, readTaskBoard.get());
        fileCommands.deleteFile("tmp.board");
        Optional<TaskBoard> readAgain = fileCommands.readTaskBoardFromFile("tmp.board");
        Assertions.assertEquals(Optional.empty(),readAgain);
    }
}