package com.evgeniy.task;

import java.util.Date;

/**
 * Задача из таскбоарда
 *
 * По-умолчанию задача иметь Status.OPEN
 */
public interface Task {

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
}
