package com.evgeniy.task.board;

import com.evgeniy.task.Task;

import java.util.Comparator;
import java.util.List;

public interface TaskBoard<T> extends Cloneable,Iterable<Task<T>> {

    /**
     * Пытается добавить задачу на доску
     *
     * @return true - если получилось добавить, иначе - false
     */
    boolean addTask(Task<T> task);

    /**
     * Пытается удалить переданную задачу из доски
     *
     * @return true - если получилось удалить, иначе - false
     */
    boolean removeTask(Task<T> task);

    /**
     * Пытается удалить задачу из доски по айди задачи
     *
     * @return true - если получилось удалить, иначе - false
     */
    boolean removeTask(Long taskId);

    /**
     * @return Список всех задач из доски
     */
    List<Task<T>> getAllTask();

    /**
     * @param taskId - уникальный идентификатор таски
     * @return Задача из таскбоарда
     */
    Task<T> getTaskById(Long taskId);

    TaskBoard<T> clone() throws CloneNotSupportedException;

    void sort();

    void sort(Comparator<Task<T>> comparator);

}
