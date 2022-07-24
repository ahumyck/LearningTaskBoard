package com.evgeniy.task.reward;

import java.io.Serial;
import java.io.Serializable;

public class BadgeReward implements Reward, Serializable {

    @Serial
    private static final long serialVersionUID = 6558802374159422413L;
    private String badge;

    public BadgeReward(String badge) {
        this.badge = badge;
    }

    public String toString() {
        return badge;
    }
}
