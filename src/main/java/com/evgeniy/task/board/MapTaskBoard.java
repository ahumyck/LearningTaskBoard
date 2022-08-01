package com.evgeniy.task.board;

import com.evgeniy.task.Task;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public interface MapTaskBoard extends Cloneable,Iterable<Task>{
    /**
     * Пытается добавить задачу на доску
     *
     * @return true - если получилось добавить, иначе - false
     */
    Task addTask(long key, Task task);

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
    Map<Long, Task> getAllTask();

    /**
     * @param taskId - уникальный идентификатор таски
     * @return Задача из таскбоарда
     */
    Optional<Task> getTaskById(Long taskId);

    MapTaskBoard clone() throws CloneNotSupportedException;

    void sort();

    void sort(Comparator<Task> comparator);
}
