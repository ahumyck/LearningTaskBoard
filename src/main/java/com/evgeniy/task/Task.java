package com.evgeniy.task;

import java.util.Date;

/**
 * Задача из таскбоарда
 *
 * По-умолчанию задача иметь Status.OPEN
 */
public interface Task extends Cloneable{

    /**
     * @return Возвращает уникальный идентификатор
     */
    Long getId();

    /**
     *
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
}
