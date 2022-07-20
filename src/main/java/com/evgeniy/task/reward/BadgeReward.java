package com.evgeniy.task.reward;

import java.io.Serializable;

public class BadgeReward implements Reward, Serializable {

    private String badge;

    public BadgeReward(String badge) {
        this.badge = badge;
    }

    public String toString() {
        return badge;
    }
}
