package com.evgeniy.task.board;

import com.evgeniy.task.Task;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListImplementationTaskBoard implements ListTaskBoard, Serializable {

    @Serial
    private static final long serialVersionUID = -9128371872503017141L;
    private List<Task> tasks = new ArrayList<>();

    @Override
    public boolean addTasks(CollectionTaskBoard tasks) {
        if (tasks.getAllTask().isEmpty()) {
            return false;
        } else {
            Stream<Task> stream = tasks.stream();
            Stream<Task> result = Stream.concat(this.tasks.stream(), stream);
            this.tasks = result.collect(Collectors.toList());
            return true;
        }
    }

    @Override
    public Stream<Task> stream() {
        return this.tasks.stream();
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
    public List<Task> getAllTask() {
        return Collections.unmodifiableList(this.tasks);
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
    public ListTaskBoard clone() throws CloneNotSupportedException {
        ListImplementationTaskBoard taskBoard = new ListImplementationTaskBoard();
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
        if (obj instanceof ListTaskBoard taskBoard) {
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Task task:this.tasks){
            sb.append(task.toString()).append("\n");

        }
        return sb.toString();
    }

}
