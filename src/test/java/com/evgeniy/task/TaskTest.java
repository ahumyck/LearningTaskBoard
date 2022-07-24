package com.evgeniy.task;

import com.evgeniy.files.FileDeleter;
import com.evgeniy.files.FilesManager;
import com.evgeniy.files.DefaultDeleter;
import com.evgeniy.task.creation.TaskCreationService;
import com.evgeniy.task.reward.BadgeReward;
import com.evgeniy.task.reward.MoneyReward;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

class TaskTest {
    @Test
    void taskCloneEquals() throws CloneNotSupportedException {
        Task task = TaskCreationService.getInstance().createTask("name", "description", new MockReward());
        Task taskClone = task.clone();
        Assertions.assertEquals(taskClone, task);
        Assertions.assertNotSame(taskClone, task);
    }

    @Test
    void taskCloneEqualsWithStatus() throws CloneNotSupportedException {
        Task task = TaskCreationService.getInstance().createTask("name", "description", new MockReward());
        task.setStatus(Status.EXPIRED);
        Task taskClone = task.clone();
        Assertions.assertEquals(taskClone, task);
        Assertions.assertNotSame(taskClone, task);
    }

    @Test
    void taskReward() {
        Task task = TaskCreationService.getInstance().createTask("name", "description", new MoneyReward(0L));
        Optional<MoneyReward> reward = task.getReward(MoneyReward.class);
        Optional<BadgeReward> reward1 = task.getReward(BadgeReward.class);
        Assertions.assertNotEquals(Optional.empty(), reward);
        reward.ifPresent(val -> Assertions.assertEquals(MoneyReward.class, val.getClass()));
        Assertions.assertEquals(Optional.empty(), reward1);
    }

    @Test
    void taskWriteRead() throws IOException, ClassNotFoundException {
        FilesManager fileCommands = new FilesManager();
        FileDeleter deleter = new DefaultDeleter();
        Task task = TaskCreationService.getInstance().createTask("name", "description", new MoneyReward(0L));
        fileCommands.writeIntoFile("tmp.task", task);
        Optional<Task> readTask = fileCommands.readFromFile("tmp.task", Task.class);
        readTask.ifPresentOrElse((value) -> System.out.println("Task was read."), Assertions::fail);
        deleter.deleteFile("tmp.task");
        Optional<Task> readAgain = fileCommands.readFromFile("tmp.task", Task.class);
        Assertions.assertEquals(Optional.empty(), readAgain);
    }
}