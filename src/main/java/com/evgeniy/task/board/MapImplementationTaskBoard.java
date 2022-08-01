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
        if (!tasks.isEmpty()) {
            throw new MapNotEmptyException("Map isn't empty!");
        }
        this.tasks = tasks;
    }

    public boolean addTask(Task task) {
        return tasks.put(task.getId(), task) != null;
    }



    @Override
    public boolean removeTask(Task task) {
        return removeTask(task.getId());
    }

    @Override
    public boolean removeTask(Long taskId) {
        for (Map.Entry<Long, Task> entry : tasks.entrySet()) {
            if (entry.getValue().getId().equals(taskId)) {
                return tasks.remove(entry.getKey())!=null;
            }
        }
        return false;
    }

    @Override
    public Collection<Task> getAllTask() {
        return this.tasks.values();
    }

    @Override
    public Optional<Task> getTaskById(Long taskId) {
        return Optional.ofNullable(this.tasks.get(taskId));
    }


    @Override
    public MapTaskBoard clone() throws CloneNotSupportedException {
        MapImplementationTaskBoard taskBoard = new MapImplementationTaskBoard(new HashMap<>());
        for (Map.Entry<Long, Task> entry : this.tasks.entrySet()) {
            taskBoard.addTask(entry.getValue().clone());
        }
        return taskBoard;
    }

    @Override
    public void sort() {
        List<Task> list = new ArrayList<>(this.tasks.values());
        Collections.sort(list);
    }

    @Override
    public void sort(Comparator<Task> comparator) {
        List<Task> list = new ArrayList<>(this.tasks.values());
        Collections.sort(list, comparator);
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
                for (Map.Entry<Long, Task> entry : tasks.entrySet()) {
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
        for (Task entry : this.tasks.values()) {
            sb.append(entry.toString()).append("\n");

        }
        return sb.toString();
    }
}
