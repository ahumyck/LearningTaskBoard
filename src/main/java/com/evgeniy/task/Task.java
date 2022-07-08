package com.evgeniy.task;

import com.evgeniy.task.reward.Reward;

import java.util.Date;

/**
 * Задача из таскбоарда
 * <p>
 * По-умолчанию задача иметь Status.OPEN
 */
public interface Task<T> extends Cloneable, Comparable<Task<T>> {

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

    Task<T> clone() throws CloneNotSupportedException;

    <T> Reward<T> getReward();

}
