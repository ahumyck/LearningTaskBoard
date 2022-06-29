package com.evgeniy.task;

import java.util.Date;

public class DefaultTask implements Task{
    private final Long id;
    private String name;
    private String description;
    private Status status;
    private Date creationDate;

    public DefaultTask(Long id, String name, String description) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.status = Status.OPEN;
        this.creationDate = creationDate;
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
        return creationDate;
    }

    @Override
    public String toString() {
        return (getId()+". "+getName()+". "+getDescription()+". "+getStatus()+"\n");
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
