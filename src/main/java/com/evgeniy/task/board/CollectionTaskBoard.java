package com.evgeniy.task.board;

import com.evgeniy.task.Task;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public interface CollectionTaskBoard extends Cloneable,Iterable<Task> {


    boolean addTasks(CollectionTaskBoard tasks);
    Stream<Task> stream();
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
    Collection<Task> getAllTask();

    /**
     * @param taskId - уникальный идентификатор таски
     * @return Задача из таскбоарда
     */
    Optional<Task> getTaskById(Long taskId);

    CollectionTaskBoard clone() throws CloneNotSupportedException;

    void sort();

    void sort(Comparator<Task> comparator);

}
