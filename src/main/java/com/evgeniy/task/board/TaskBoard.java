package com.evgeniy.task.board;

import com.evgeniy.task.Task;

import java.util.List;

public interface TaskBoard extends Cloneable,Iterable<Task> {

    /**
     * Пытается добавить задачу на доску
     *
     * @return true - если получилось добавить, иначе - false
     */
    boolean addTask(Task task);

    /**
     * Пытается удалить переданную задачу из доски
     *
     * @return true - если получилось удалить, иначе - false
     */
    boolean removeTask(Task task);

    /**
     * Пытается удалить задачу из доски по айди задачи
     *
     * @return true - если получилось удалить, иначе - false
     */
    boolean removeTask(Long taskId);

    /**
     * @return Список всех задач из доски
     */
    List<Task> getAllTask();

    /**
     * @param taskId - уникальный идентификатор таски
     * @return Задача из таскбоарда
     */
    Task getTaskById(Long taskId);

    TaskBoard clone() throws CloneNotSupportedException;

}
