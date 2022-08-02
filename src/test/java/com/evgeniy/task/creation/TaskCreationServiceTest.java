package com.evgeniy.task.creation;

import com.evgeniy.task.Task;
import com.evgeniy.task.board.*;
import com.evgeniy.task.exception.NoRewardException;
import com.evgeniy.task.MockReward;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.Supplier;


class TaskCreationServiceTest {
    @Test
    void createIdSequence() {
        Task task1 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task2 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task3 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task4 = TaskCreationService.getInstance().createTask("", "", new MockReward());

        Assertions.assertEquals(task2.getId() - task1.getId(), 1);
        Assertions.assertEquals(task3.getId() - task2.getId(), 1);
        Assertions.assertEquals(task4.getId() - task3.getId(), 1);
    }

    @Test
    void listAddingCheck() {
        tasksAddingCheck(ListImplementationTaskBoard::new);
    }

    @Test
    void collectionAddingCheck() {
        tasksAddingCheck(() -> new CollectionImplementationTaskBoard(new ArrayList<>()));
    }

    @Test
    void mapAddingCheck() {
        tasksAddingCheck(() -> new MapImplementationTaskBoard(new HashMap<>()));
    }
    private void tasksAddingCheck(Supplier<CollectionTaskBoard> collectionTaskBoardSupplier){
        CollectionTaskBoard taskBoard = collectionTaskBoardSupplier.get();

        Task task1 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task2 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task3 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task4 = TaskCreationService.getInstance().createTask("", "", new MockReward());
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
    void listRemovingCheck() {
        tasksRemovingCheck(ListImplementationTaskBoard::new);
    }

    @Test
    void collectionRemovingCheck() {
        tasksRemovingCheck(() -> new CollectionImplementationTaskBoard(new ArrayList<>()));
    }

    @Test
    void mapRemovingCheck() {
        tasksRemovingCheck(() -> new MapImplementationTaskBoard(new HashMap<>()));
    }
    private void tasksRemovingCheck(Supplier<CollectionTaskBoard> collectionTaskBoardSupplier){
        CollectionTaskBoard taskBoard2 = collectionTaskBoardSupplier.get();
        Task task5 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task6 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task7 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        Task task8 = TaskCreationService.getInstance().createTask("", "", new MockReward());
        taskBoard2.addTask(task5);
        taskBoard2.addTask(task6);
        taskBoard2.addTask(task7);
        taskBoard2.addTask(task8);

        Assertions.assertTrue(taskBoard2.removeTask(task5));
        Assertions.assertTrue(taskBoard2.removeTask(task8));
        Assertions.assertNotNull(taskBoard2.getTaskById(task6.getId()));
        Assertions.assertNotNull(taskBoard2.getTaskById(task7.getId()));
    }

    @Test
    void checkRewardException(){
        Assertions.assertThrowsExactly(NoRewardException.class, () -> TaskCreationService.getInstance().createTask("name", "desc", null));
    }
}