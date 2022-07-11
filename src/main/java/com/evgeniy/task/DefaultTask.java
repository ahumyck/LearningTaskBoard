package com.evgeniy.task;

import com.evgeniy.task.reward.BadgeReward;
import com.evgeniy.task.reward.MoneyReward;
import com.evgeniy.task.reward.PromiseReward;
import com.evgeniy.task.reward.Reward;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

public class DefaultTask implements Task {
    private final Long id;
    private String name;
    private String description;
    private Status status;
    private final Date creationDate;
    private Reward reward;

    public DefaultTask(Long id, String name, String description, Reward reward) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = Status.OPEN;
        this.creationDate = Date.from(Instant.now());
        this.reward = reward;
    }

    public DefaultTask(Long id, String name, String description, Reward reward, Status status) {
        this(id, name, description, reward);
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
        sb.append("taskId = ").append(getId()).append(", ").append("name = ").append(getName()).append(", ").append("description = ").append(getDescription()).append(", ").append("status = ").append(getStatus()).append(", ").append("creation date = ").append(getCreationTime()).append(", ").append("reward = ").append(getReward(this.reward.getClass()).get()).append(".");
        return sb.toString();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Task clone() throws CloneNotSupportedException {
        return new DefaultTask(this.id, this.name, this.description, this.reward, this.status);
    }

    public <T extends Reward> Optional<T> getReward(Class<T> rewardType) {
       if(this.reward.getClass()!=rewardType){
           return Optional.empty();
       }
        return (Optional<T>) Optional.of(this.reward);
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

    @Override
    public int compareTo(Task task) {
        return this.getName().compareTo(task.getName());
    }

}

