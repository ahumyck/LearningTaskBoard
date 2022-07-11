package com.evgeniy.task.board;

import com.evgeniy.task.Task;
import com.evgeniy.task.creation.TaskCreationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskBoardTest {
    @Test
    void taskBoardCloneEquals() throws CloneNotSupportedException {
        Task task1 = TaskCreationService.getInstance().createTask("name1", "description1", null);
        Task task2 = TaskCreationService.getInstance().createTask("name2", "description2", null);
        Task task3 = TaskCreationService.getInstance().createTask("name3", "description3", null);
        Task task4 = TaskCreationService.getInstance().createTask("name4", "description4", null);
        TaskBoard taskBoard = new DefaultTaskBoard();

        taskBoard.addTask(task1);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task4);

        TaskBoard cloneTaskBoard = taskBoard.clone();
        Assertions.assertEquals(cloneTaskBoard, taskBoard);
        Assertions.assertNotSame(cloneTaskBoard, taskBoard);
    }
}