package com.evgeniy.task.board;

import com.evgeniy.task.Task;
import com.evgeniy.task.creation.TaskCreationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskBoardTest {
    @Test
    void taskBoardCloneEquals() throws CloneNotSupportedException {
        Task<Long> task1 = TaskCreationService.getInstance().createTask("name1", "description1", null);
        Task<Long> task2 = TaskCreationService.getInstance().createTask("name2", "description2", null);
        Task<Long> task3 = TaskCreationService.getInstance().createTask("name3", "description3", null);
        Task<Long> task4 = TaskCreationService.getInstance().createTask("name4", "description4", null);
        TaskBoard<Long> taskBoard = new DefaultTaskBoard<>();

        taskBoard.addTask(task1);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task4);

        TaskBoard<Long> cloneTaskBoard = taskBoard.clone();
        Assertions.assertEquals(cloneTaskBoard, taskBoard);
        Assertions.assertNotSame(cloneTaskBoard, taskBoard);
    }
}