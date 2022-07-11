package com.evgeniy.task;

import com.evgeniy.task.creation.TaskCreationService;
import com.evgeniy.task.reward.BadgeReward;
import com.evgeniy.task.reward.MoneyReward;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class TaskTest {
    @Test
    void taskCloneEquals() throws CloneNotSupportedException {
        Task task = TaskCreationService.getInstance().createTask("name", "description", null);
        Task taskClone = task.clone();
        Assertions.assertEquals(taskClone, task);
        Assertions.assertNotSame(taskClone, task);
    }

    @Test
    void taskCloneEqualsWithStatus() throws CloneNotSupportedException {
        Task task = TaskCreationService.getInstance().createTask("name", "description", null);
        task.setStatus(Status.EXPIRED);
        Task taskClone = task.clone();
        Assertions.assertEquals(taskClone, task);
        Assertions.assertNotSame(taskClone, task);
    }

    @Test
    void taskReward(){
        Task task = TaskCreationService.getInstance().createTask("name", "description", new MoneyReward(0L));
        Optional<MoneyReward> reward = task.getReward(MoneyReward.class);
        Optional<BadgeReward> reward1 = task.getReward(BadgeReward.class);
        Assertions.assertNotEquals(Optional.empty(),reward);
        Assertions.assertEquals(MoneyReward.class, reward.get().getClass());
        Assertions.assertEquals(Optional.empty(),reward1);
    }
}