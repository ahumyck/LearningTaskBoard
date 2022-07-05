package com.evgeniy.task;

import com.evgeniy.task.Task;
import com.evgeniy.task.creation.TaskCreationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    void taskCloneEquals() throws CloneNotSupportedException {
        Task task = TaskCreationService.getInstance().createTask("name", "description");
        Task taskClone = task.clone();
        Assertions.assertTrue(taskClone.equals(task) && taskClone != task);
    }
}