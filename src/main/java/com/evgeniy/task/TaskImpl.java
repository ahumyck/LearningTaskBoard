package com.evgeniy.task;
import com.evgeniy.task.Status;
import com.evgeniy.task.Task;

import java.util.Date;

public class TaskImpl implements Task{
    private Long id;
    private String name;
    private String description;
    private Status status;
    private Date ctime;

    public TaskImpl(Long id, String name, String description, Status status, Date ctime) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.ctime = ctime;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    public Date getCreationTime() {
        return ctime;
    }
}
