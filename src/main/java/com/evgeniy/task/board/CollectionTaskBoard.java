package com.evgeniy.task.board;

import com.evgeniy.task.Task;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Stream;

public interface CollectionTaskBoard extends Cloneable, Iterable<Task> {


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

    static Collector<Task, ListTaskBoard, ListTaskBoard> toListTaskBoard() {
        return Collector.of(ListImplementationTaskBoard::new,
                ListTaskBoard::addTask,
                (tasks1, tasks2) -> {
                    tasks1.addTasks(tasks2);
                    return tasks1;
                });
    }

    static Collector<Task, MapTaskBoard, MapTaskBoard> toMapTaskBoard() {
        return Collector.of(MapImplementationTaskBoard::new,
                MapTaskBoard::addTask,
                (tasks1, tasks2) -> {
                    tasks1.addTasks(tasks2);
                    return tasks1;
                });
    }
}
