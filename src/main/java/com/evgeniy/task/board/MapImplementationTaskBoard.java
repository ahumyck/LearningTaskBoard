package com.evgeniy.task.board;

import com.evgeniy.task.Task;
import com.evgeniy.task.exception.empty.MapNotEmptyException;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class MapImplementationTaskBoard implements MapTaskBoard, Serializable {
    @Serial
    private static final long serialVersionUID = -9128371872503017141L;
    private Map<Long, Task> tasks = new HashMap<>();

    public MapImplementationTaskBoard(Map<Long, Task> tasks) {
        if(!tasks.isEmpty()){
            throw new MapNotEmptyException("Map isn't empty!");
        }
        this.tasks = tasks;
    }

    public Task addTask(long key, Task task) {
        return tasks.put(key,task);
    }


    @Override
    public boolean removeTask(Task task) {
        return removeTask(task.getId());
    }

    @Override
    public boolean removeTask(Long taskId) {
        for (var entry : tasks.entrySet()) {
            if (entry.getValue().getId().equals(taskId)) {
                return tasks.values().remove(entry.getValue());
            }
        }
        return false;
    }

    @Override
    public Map<Long, Task> getAllTask() {
        return this.tasks;
    }

    @Override
    public Optional<Task> getTaskById(Long taskId) {
        for (var entry : tasks.entrySet()) {
            if (entry.getValue().getId().equals(taskId)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public MapTaskBoard clone() throws CloneNotSupportedException {
        MapImplementationTaskBoard taskBoard = new MapImplementationTaskBoard(new HashMap<>());
        for (var entry : this.tasks.entrySet()) {
            taskBoard.addTask(entry.getKey(), entry.getValue().clone());
        }
        return taskBoard;
    }

    @Override
    public void sort() {
        System.out.println(this.tasks.entrySet().stream().sorted());
    }

    @Override
    public void sort(Comparator<Task> comparator) {
        List<Task> mapValues = new ArrayList<>(this.tasks.values());
        mapValues.sort(comparator);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this == obj) {
            return true;
        }
        if (obj instanceof MapTaskBoard taskBoard) {
            if (taskBoard.getAllTask().size() == this.tasks.size()) {
                for (var entry : tasks.entrySet()) {
                    Optional<Task> taskFromBoard = taskBoard.getTaskById(entry.getValue().getId());
                    if (taskFromBoard.isEmpty()) {
                        return false;
                    }
                    if (!entry.getValue().equals(taskFromBoard.get())) {
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
        return this.tasks.values().iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var entry:this.tasks.entrySet()){
            sb.append(entry.getValue().toString()).append("\n");

        }
        return sb.toString();
    }
}
