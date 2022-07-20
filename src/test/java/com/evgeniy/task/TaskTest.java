package com.evgeniy.task;

import com.evgeniy.files.WorkWithFiles;
import com.evgeniy.task.creation.TaskCreationService;
import com.evgeniy.task.reward.BadgeReward;
import com.evgeniy.task.reward.MoneyReward;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
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
        Task task = TaskCreationService.getInstance().createTask("name", "description", new MoneyReward(0L));
        File file = new File("E:/intellijfiles/tmp.task");
        if (file.createNewFile()) {
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }
        WorkWithFiles.WriteTaskIntoFile(task, "E:/intellijfiles/tmp.task");
        Task readTask = WorkWithFiles.ReadTaskFromFile("E:/intellijfiles/tmp.task");
        Assertions.assertEquals(task, readTask);
        System.out.println(file.delete());
        Task readAgain = WorkWithFiles.ReadTaskFromFile("E:/intellijfiles/tmp.task");
        Assertions.assertNull(readAgain);
    }
}