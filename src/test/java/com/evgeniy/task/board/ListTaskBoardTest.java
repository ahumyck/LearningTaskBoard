package com.evgeniy.task.board;

import com.evgeniy.files.FileDeleter;
import com.evgeniy.files.FilesManager;
import com.evgeniy.files.DefaultDeleter;
import com.evgeniy.task.Task;
import com.evgeniy.task.creation.TaskCreationService;
import com.evgeniy.task.MockReward;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;


class ListTaskBoardTest {

    @Test
    void taskBoardCloneEquals() throws CloneNotSupportedException {
        Task task1 = TaskCreationService.getInstance().createTask("name1", "description1", new MockReward());
        Task task2 = TaskCreationService.getInstance().createTask("name2", "description2", new MockReward());
        Task task3 = TaskCreationService.getInstance().createTask("name3", "description3", new MockReward());
        Task task4 = TaskCreationService.getInstance().createTask("name4", "description4", new MockReward());
        ListTaskBoard taskBoard = new ListImplementationTaskBoard();

        taskBoard.addTask(task1);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task4);

        ListTaskBoard cloneTaskBoard = taskBoard.clone();
        Assertions.assertEquals(cloneTaskBoard, taskBoard);
        Assertions.assertNotSame(cloneTaskBoard, taskBoard);
    }

    @Test
    void taskBoardWriteRead() throws ClassNotFoundException {
        Task task1 = TaskCreationService.getInstance().createTask("name1", "description1", new MockReward());
        Task task2 = TaskCreationService.getInstance().createTask("name2", "description2", new MockReward());
        Task task3 = TaskCreationService.getInstance().createTask("name3", "description3", new MockReward());
        Task task4 = TaskCreationService.getInstance().createTask("name4", "description4", new MockReward());
        ListTaskBoard taskBoard = new ListImplementationTaskBoard();

        taskBoard.addTask(task1);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task4);
        FilesManager fileCommands = new FilesManager();
        FileDeleter deleter = new DefaultDeleter();
        fileCommands.writeIntoFile("tmp.board", taskBoard);
        Optional<ListTaskBoard> readTaskBoard = fileCommands.readFromFile("tmp.board", ListTaskBoard.class);
        readTaskBoard.ifPresentOrElse((value) -> Assertions.assertEquals(taskBoard,value), Assertions::fail);
        deleter.deleteFile("tmp.board");
        Optional<CollectionTaskBoard> readAgain = fileCommands.readFromFile("tmp.board", CollectionTaskBoard.class);
        Assertions.assertEquals(Optional.empty(), readAgain);
    }
}