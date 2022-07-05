package com.evgeniy.task;

import com.evgeniy.task.creation.TaskCreationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    void taskCloneEquals() throws CloneNotSupportedException {
        Task task = TaskCreationService.getInstance().createTask("name", "description");
        Task taskClone = task.clone();
        Assertions.assertEquals(taskClone, task);
        Assertions.assertNotSame(taskClone, task);
    }

    @Test
    void taskCloneEqualsWithStatus() throws CloneNotSupportedException {
        Task task = TaskCreationService.getInstance().createTask("name", "description");
        task.setStatus(Status.EXPIRED);
        Task taskClone = task.clone();
        Assertions.assertEquals(taskClone, task);
        Assertions.assertNotSame(taskClone, task);
    }
}