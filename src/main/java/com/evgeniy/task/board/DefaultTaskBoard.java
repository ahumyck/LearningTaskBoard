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
        boolean result = false;
        for(int i=0; i<tasks.size();i++){
            Task task = tasks.get(i);
            if (task.getId()==taskId){
                tasks.remove(i);
                result = true;
            }
            else{continue;}
        }
        return result;
    }

    @Override
    public List<Task> getAllTask() {
        return tasks;
    }

    @Override
    public Task getTaskById(Long taskId) {
        Task result = null;
        for(int j=0; j<tasks.size();j++){
            Task task = tasks.get(j);
            if (task.getId()==taskId){
                result = task;
            }
            else{continue;}
        }
        return result;
        }


    public List<Task> getTasksByStatus(Status status) {

        return tasks;
    }
}
