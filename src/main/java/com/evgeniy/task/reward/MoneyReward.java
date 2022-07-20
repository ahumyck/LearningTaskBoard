package com.evgeniy.task.reward;

import java.io.Serializable;

public class MoneyReward implements Reward, Serializable {
    private static final long serialVersionUID = 1L;
    private long money;

    public MoneyReward(long money) {
        this.money = money;
    }

    public String toString() {
        return Long.toString(money);
    }
}
