package com.evgeniy.task.board;

import com.evgeniy.task.MockReward;
import com.evgeniy.task.Task;
import com.evgeniy.task.creation.TaskCreationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MapTaskBoardTest {

    @Test
    void taskBoardCloneEquals() throws CloneNotSupportedException {
        Task task1 = TaskCreationService.getInstance().createTask("name1", "description1", new MockReward());
        Task task2 = TaskCreationService.getInstance().createTask("name2", "description2", new MockReward());
        Task task3 = TaskCreationService.getInstance().createTask("name3", "description3", new MockReward());
        Task task4 = TaskCreationService.getInstance().createTask("name4", "description4", new MockReward());
        MapTaskBoard taskBoard = new MapImplementationTaskBoard(new HashMap<>());

        taskBoard.addTask(0, task1);
        taskBoard.addTask(1, task2);
        taskBoard.addTask(2, task3);
        taskBoard.addTask(3, task4);

        MapTaskBoard cloneTaskBoard = taskBoard.clone();
        Assertions.assertEquals(cloneTaskBoard, taskBoard);
        Assertions.assertNotSame(cloneTaskBoard, taskBoard);
    }

    @Test
    void tasksAddingCheck() {
        MapTaskBoard taskBoard = new MapImplementationTaskBoard(new HashMap<>());

        Task task1 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task2 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task3 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task4 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        taskBoard.addTask(0, task1);
        taskBoard.addTask(1, task2);
        taskBoard.addTask(2, task3);
        taskBoard.addTask(3, task4);

        Assertions.assertNotNull(taskBoard.getTaskById(task1.getId()));
        Assertions.assertNotNull(taskBoard.getTaskById(task2.getId()));
        Assertions.assertNotNull(taskBoard.getTaskById(task3.getId()));
        Assertions.assertNotNull(taskBoard.getTaskById(task4.getId()));
    }

    @Test
    void tasksRemovingCheck() {
        MapTaskBoard taskBoard2 = new MapImplementationTaskBoard(new HashMap<>());
        Task task5 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task6 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task7 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task8 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        taskBoard2.addTask(0, task5);
        taskBoard2.addTask(1, task6);
        taskBoard2.addTask(2, task7);
        taskBoard2.addTask(3, task8);

        Assertions.assertTrue(taskBoard2.removeTask(task5));
        Assertions.assertTrue(taskBoard2.removeTask(task8));
        Assertions.assertNotNull(taskBoard2.getTaskById(task6.getId()));
        Assertions.assertNotNull(taskBoard2.getTaskById(task7.getId()));
    }
}
