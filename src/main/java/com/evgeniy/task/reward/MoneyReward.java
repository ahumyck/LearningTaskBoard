package com.evgeniy.task.reward;

public class MoneyReward implements Reward {

    private long money;

    public MoneyReward(long money) {
        this.money = money;
    }

    public String toString() {
        return Long.toString(money);
    }
}
