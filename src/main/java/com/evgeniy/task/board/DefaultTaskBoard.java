package com.evgeniy.task.board;

import com.evgeniy.task.Status;
import com.evgeniy.task.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultTaskBoard implements TaskBoard {
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
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
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
    public Task getTaskById(Long taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }


    public List<Task> getTasksByStatus(Status status) {

        return tasks;
    }
}
