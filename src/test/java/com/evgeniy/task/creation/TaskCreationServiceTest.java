package com.evgeniy.task.creation;

import com.evgeniy.task.Task;
import com.evgeniy.task.board.DefaultTaskBoard;
import com.evgeniy.task.board.TaskBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskCreationServiceTest {
    @Test
    void createIdSequence() {
        Task<Long> task1 = TaskCreationService.getInstance().createTask("", "", null);
        Task<Long> task2 = TaskCreationService.getInstance().createTask("", "", null);
        Task<Long> task3 = TaskCreationService.getInstance().createTask("", "", null);
        Task<Long> task4 = TaskCreationService.getInstance().createTask("", "", null);

        Assertions.assertEquals(task2.getId() - task1.getId(), 1);
        Assertions.assertEquals(task3.getId() - task2.getId(), 1);
        Assertions.assertEquals(task4.getId() - task3.getId(), 1);
    }

    @Test
    void tasksAddingCheck(){
        TaskBoard<Long> taskBoard = new DefaultTaskBoard<>();

        Task<Long> task1 = TaskCreationService.getInstance().createTask("", "", null);
        Task<Long> task2 = TaskCreationService.getInstance().createTask("", "", null);
        Task<Long> task3 = TaskCreationService.getInstance().createTask("", "", null);
        Task<Long> task4 = TaskCreationService.getInstance().createTask("", "", null);
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
        TaskBoard<Long> taskBoard2 = new DefaultTaskBoard<>();
        Task<Long> task5 = TaskCreationService.getInstance().createTask("", "", null);
        Task<Long> task6 = TaskCreationService.getInstance().createTask("", "", null);
        Task<Long> task7 = TaskCreationService.getInstance().createTask("", "", null);
        Task<Long> task8 = TaskCreationService.getInstance().createTask("", "", null);
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