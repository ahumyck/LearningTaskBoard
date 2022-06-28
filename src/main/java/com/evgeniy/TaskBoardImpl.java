package com.evgeniy;

import com.evgeniy.task.Task;
import com.evgeniy.task.board.TaskBoard;

import java.util.LinkedList;
import java.util.List;

public class TaskBoardImpl implements TaskBoard {

    @Override
    public boolean addTask(Task task) {
        return false;
    }

    @Override
    public boolean removeTask(Task task) {
        return false;
    }

    @Override
    public boolean removeTask(Long taskId) {
        return false;
    }

    @Override
    public List<Task> getAllTask() {
        return null;
    }

    @Override
    public Task getTaskById(Long taskId) {
        return null;
    }
}
