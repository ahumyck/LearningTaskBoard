package com.evgeniy.task.board;

import com.evgeniy.task.Task;
import com.evgeniy.task.exception.empty.CollectionNotEmptyException;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Stream;

public class CollectionImplementationTaskBoard implements CollectionTaskBoard, Serializable {
    @Serial
    private static final long serialVersionUID = -1233761277930413217L;
    private Collection<Task> tasks = new ArrayList<>();

    public CollectionImplementationTaskBoard(Collection<Task> tasks) {
        if (!tasks.isEmpty()) {
            throw new CollectionNotEmptyException("Collection isn't empty!");
        }
        this.tasks = tasks;
    }


    @Override
    public boolean addTask(Task task) {
        return tasks.add(task);
    }

    @Override
    public boolean removeTask(Task task) {
        return removeTask(task.getId());
    }

    @Override
    public boolean removeTask(Long taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                return tasks.remove(task);
            }
        }
        return false;
    }

    @Override
    public Collection<Task> getAllTask() {
        return this.tasks;
    }

    @Override
    public Optional<Task> getTaskById(Long taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    @Override
    public CollectionTaskBoard clone() throws CloneNotSupportedException {
        CollectionImplementationTaskBoard taskBoard = new CollectionImplementationTaskBoard(new ArrayList<>());
        for (Task task : this.tasks) {
            taskBoard.addTask(task.clone());
        }
        return taskBoard;
    }

    @Override
    public void sort() {
        List<Task> list = new ArrayList<>(this.tasks);
        Collections.sort(list);
    }

    @Override
    public void sort(Comparator<Task> comparator) {
        List<Task> list = new ArrayList<>(this.tasks);
        Collections.sort(list,comparator);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this == obj) {
            return true;
        }
        if (obj instanceof CollectionTaskBoard taskBoard) {
            if (taskBoard.getAllTask().size() == this.tasks.size()) {
                for (Task task : this.tasks) {
                    Optional<Task> taskFromBoard = taskBoard.getTaskById(task.getId());
                    if (taskFromBoard.isEmpty()) {
                        return false;
                    }
                    if (!task.equals(taskFromBoard.get())) {
                        return false;
                    }

                }
                return true;
            }

        }
        return false;
    }

    @Override
    public Iterator<Task> iterator() {
        return this.tasks.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Task task : this.tasks) {
            sb.append(task.toString()).append("\n");

        }
        return sb.toString();
    }
}
