package com.evgeniy.task.board;

import com.evgeniy.task.Task;
import com.evgeniy.task.exception.empty.MapNotEmptyException;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapImplementationTaskBoard implements MapTaskBoard, Serializable {
    @Serial
    private static final long serialVersionUID = -9128371872503017141L;
    private Map<Long, Task> tasks;


    public MapImplementationTaskBoard(Map<Long, Task> tasks) {
        if (!tasks.isEmpty()) {
            throw new MapNotEmptyException("Map isn't empty!");
        }
        this.tasks = tasks;
    }


    @Override
    public boolean addTasks(CollectionTaskBoard tasks) {
        if (tasks.getAllTask().isEmpty()) {
            return false;
        } else {
            Stream<Task> stream = tasks.stream();
            Stream<Task> result = Stream.concat(this.tasks.values().stream(), stream);
            Map<Long,Task> map = new HashMap<>();
            List<Task> list = result.toList();
            for(Task task:list){
                map.put(task.getId(),task);
            }
            this.tasks = map;
            return true;
        }
    }

    @Override
    public Stream<Task> stream() {
        return this.tasks.values().stream();
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
        return tasks.remove(taskId) != null;
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
        for (Task entry : this.tasks.values()) {
            taskBoard.addTask(entry.clone());
        }
        return taskBoard;
    }

    @Override
    public void sort() {
        this.tasks = this.tasks.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

    }

    @Override
    public void sort(Comparator<Task> comparator) {
        this.tasks = this.tasks.entrySet().stream().sorted((o1, o2) -> {
            Task task1 = o1.getValue();
            Task task2 = o2.getValue();
            return comparator.compare(task1,task2);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

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
                for (Task entry : tasks.values()) {
                    Optional<Task> taskFromBoard = taskBoard.getTaskById(entry.getId());
                    if (taskFromBoard.isEmpty()) {
                        return false;
                    }
                    if (!entry.equals(taskFromBoard.get())) {
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
