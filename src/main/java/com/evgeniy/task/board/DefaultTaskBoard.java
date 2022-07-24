package com.evgeniy.task.board;

import com.evgeniy.task.Task;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class DefaultTaskBoard implements TaskBoard, Serializable {
    @Serial
    private static final long serialVersionUID = -1233761277930413217L;
    private List<Task> tasks = new ArrayList<>();

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
    public List<Task> getAllTask() {
        return Collections.unmodifiableList(tasks);
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
    public TaskBoard clone() throws CloneNotSupportedException {
        DefaultTaskBoard taskBoard = new DefaultTaskBoard();
        for (Task task : this.tasks) {
            taskBoard.addTask(task.clone());
        }
        return taskBoard;
    }

    @Override
    public void sort() {
        Collections.sort(this.tasks);
    }

    @Override
    public void sort(Comparator<Task> comparator) {
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
                for (Task task : this.tasks) {
                    Optional<Task> taskFromBoard = taskBoard.getTaskById(task.getId());
                    if (!taskFromBoard.isPresent()) {
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
}
