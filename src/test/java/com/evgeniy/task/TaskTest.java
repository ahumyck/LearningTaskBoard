package com.evgeniy.task;

import com.evgeniy.task.creation.TaskCreationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    void taskCloneEquals() throws CloneNotSupportedException {
        Task<Long> task = TaskCreationService.getInstance().createTask("name", "description", null);
        Task<Long> taskClone = task.clone();
        Assertions.assertEquals(taskClone, task);
        Assertions.assertNotSame(taskClone, task);
    }

    @Test
    void taskCloneEqualsWithStatus() throws CloneNotSupportedException {
        Task<Long> task = TaskCreationService.getInstance().createTask("name", "description", null);
        task.setStatus(Status.EXPIRED);
        Task<Long> taskClone = task.clone();
        Assertions.assertEquals(taskClone, task);
        Assertions.assertNotSame(taskClone, task);
    }
}