package com.evgeniy.task.creation;

import com.evgeniy.task.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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

}