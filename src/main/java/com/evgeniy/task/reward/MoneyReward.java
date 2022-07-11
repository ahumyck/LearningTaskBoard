package com.evgeniy.task.reward;

public class MoneyReward implements Reward {

    private long money;

    public MoneyReward(long money) {
        this.money = money;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(money);
        return sb.toString();
    }
}
