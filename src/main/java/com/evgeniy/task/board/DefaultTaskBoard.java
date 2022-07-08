package com.evgeniy.task.board;

import com.evgeniy.task.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;

public class DefaultTaskBoard<T> implements TaskBoard<T> {
    private List<Task<T>> tasks = new ArrayList<>();

    @Override
    public boolean addTask(Task<T> task) {
        return tasks.add(task);
    }

    @Override
    public boolean removeTask(Task<T> task) {
        return removeTask(task.getId());
    }

    @Override
    public boolean removeTask(Long taskId) {
        for (Task<T> task : tasks) {
            if (task.getId().equals(taskId)) {
                return tasks.remove(task);
            }
        }
        return false;
    }

    @Override
    public List<Task<T>> getAllTask() {
        return Collections.unmodifiableList(tasks);
    }

    @Override
    public Task<T> getTaskById(Long taskId) {
        for (Task<T> task : tasks) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }

    @Override
    public TaskBoard<T> clone() throws CloneNotSupportedException {
        DefaultTaskBoard<T> taskBoard = new DefaultTaskBoard<>();
        for (Task<T> task : this.tasks) {
            taskBoard.addTask(task.clone());
        }
        return taskBoard;
    }

    @Override
    public void sort() {
        Collections.sort(this.tasks);
    }

    @Override
    public void sort(Comparator<Task<T>> comparator) {
        this.tasks.sort(comparator);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this == obj) {
            return true;
        }
        if (obj instanceof TaskBoard taskBoard) {
            if (taskBoard.getAllTask().size() == this.tasks.size()) {
                for (Task<T> task : this.tasks) {
                    if (!task.equals(taskBoard.getTaskById(task.getId()))) {
                        return false;
                    }
                }
                return true;
            }

        }
        return false;
    }

    @Override
    public Iterator<Task<T>> iterator() {
        return this.tasks.iterator();
    }
}
