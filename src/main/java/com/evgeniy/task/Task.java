package com.evgeniy.task;

import com.evgeniy.task.reward.Reward;

import java.util.Date;
import java.util.Optional;

/**
 * Задача из таскбоарда
 * <p>
 * По-умолчанию задача иметь Status.OPEN
 */
public interface Task extends Cloneable,Comparable<Task> {

    /**
     * @return Возвращает уникальный идентификатор
     */
    Long getId();

    /**
     * @return Имя задачи
     */
    String getName();

    /**
     * @return Описание, что нужно сделать
     */
    String getDescription();

    /**
     * @return Статус задачи
     */
    Status getStatus();

    /**
     * @return Время создания задачи
     */
    Date getCreationTime();

    void setStatus(Status status);

    Task clone() throws CloneNotSupportedException;

    <T extends Reward> Optional<T> getReward(Class<T> rewardType);


}
