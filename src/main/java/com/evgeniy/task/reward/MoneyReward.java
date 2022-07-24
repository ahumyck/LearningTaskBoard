package com.evgeniy.task.reward;

import java.io.Serial;
import java.io.Serializable;

public class MoneyReward implements Reward, Serializable {

    @Serial
    private static final long serialVersionUID = 4979974502303867531L;
    private final long money;

    public MoneyReward(long money) {
        this.money = money;
    }

    public String toString() {
        return Long.toString(money);
    }
}
