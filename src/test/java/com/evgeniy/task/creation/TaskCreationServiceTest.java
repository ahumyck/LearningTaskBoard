package com.evgeniy.task.creation;

import com.evgeniy.task.Task;
import com.evgeniy.task.board.DefaultTaskBoard;
import com.evgeniy.task.board.TaskBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskCreationServiceTest {
    @Test
    void createIdSequence() {
        Task task1 = TaskCreationService.getInstance().createTask("", "");
        Task task2 = TaskCreationService.getInstance().createTask("", "");
        Task task3 = TaskCreationService.getInstance().createTask("", "");
        Task task4 = TaskCreationService.getInstance().createTask("", "");

        Assertions.assertEquals(task2.getId() - task1.getId(), 1);
        Assertions.assertEquals(task3.getId() - task2.getId(), 1);
        Assertions.assertEquals(task4.getId() - task3.getId(), 1);
    }

    @Test
    void tasksAddingCheck(){
        TaskBoard taskBoard = new DefaultTaskBoard();
        Task task1 = TaskCreationService.getInstance().createTask("", "");
        Task task2 = TaskCreationService.getInstance().createTask("", "");
        Task task3 = TaskCreationService.getInstance().createTask("", "");
        Task task4 = TaskCreationService.getInstance().createTask("", "");
        taskBoard.addTask(task1);
        taskBoard.addTask(task2);
        taskBoard.addTask(task3);
        taskBoard.addTask(task4);

        Assertions.assertNotNull(taskBoard.getTaskById(task1.getId()));
        Assertions.assertNotNull(taskBoard.getTaskById(task2.getId()));
        Assertions.assertNotNull(taskBoard.getTaskById(task3.getId()));
        Assertions.assertNotNull(taskBoard.getTaskById(task4.getId()));
    }

    @Test
    void tasksRemovingCheck(){
        TaskBoard taskBoard2 = new DefaultTaskBoard();
        Task task5 = TaskCreationService.getInstance().createTask("", "");
        Task task6 = TaskCreationService.getInstance().createTask("", "");
        Task task7 = TaskCreationService.getInstance().createTask("", "");
        Task task8 = TaskCreationService.getInstance().createTask("", "");
        taskBoard2.addTask(task5);
        taskBoard2.addTask(task6);
        taskBoard2.addTask(task7);
        taskBoard2.addTask(task8);

        Assertions.assertTrue(taskBoard2.removeTask(task5));
        Assertions.assertTrue(taskBoard2.removeTask(task8));
        Assertions.assertNotNull(taskBoard2.getTaskById(task6.getId()));
        Assertions.assertNotNull(taskBoard2.getTaskById(task7.getId()));
    }
}