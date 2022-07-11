package com.evgeniy.task.reward;

public class BadgeReward implements Reward{

    private String badge;

    public BadgeReward(String badge) {
        this.badge = badge;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(badge);
        return sb.toString();
    }
}
