package com.evgeniy.task;

import java.time.Instant;
import java.util.Date;

public class DefaultTask implements Task {
    private final Long id;
    private String name;
    private String description;
    private Status status;
    private final Date creationDate;

    public DefaultTask(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = Status.OPEN;
        this.creationDate = Date.from(Instant.now());
    }

    public DefaultTask(Long id, String name, String description, Status status) {
        this(id, name, description);
        this.status = status;
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
        StringBuilder sb = new StringBuilder();
        sb.append("taskId = ").append(getId()).append(", ").append("name = ").append(getName()).append(", ").append("description = ").append(getDescription()).append(", ").append("status = ").append(getStatus()).append(", ").append("creation date = ").append(getCreationTime()).append(".");
        return sb.toString();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Task clone() throws CloneNotSupportedException {
        return new DefaultTask(this.id, this.name, this.description, this.status);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this == obj) {
            return true;
        }
        if (obj instanceof Task task) {
            return this.getId().equals(task.getId()) &&
                    this.getName().equals(task.getName()) &&
                    this.getDescription().equals(task.getDescription()) &&
                    this.getStatus().equals(task.getStatus());
        }
        return false;
    }
}

