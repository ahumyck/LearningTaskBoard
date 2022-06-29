package com.evgeniy.task.board;

import com.evgeniy.task.Status;
import com.evgeniy.task.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultTaskBoard implements TaskBoard {
    List<Task> tasks = new ArrayList<>();

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
        tasks.remove(taskId.intValue());
        Task task = tasks.get(taskId.intValue());
        return tasks.contains(task);
    }

    @Override
    public List<Task> getAllTask() {
        return tasks;
    }

    @Override
    public Task getTaskById(Long taskId) {
        return tasks.get(taskId.intValue());
    }

    public List<Task> getTasksByStatus(Status status) {

        return tasks;
    }
}
