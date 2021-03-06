package com.evgeniy.task;

import com.evgeniy.task.reward.Reward;

import java.io.Serial;
import java.io.Serializable;

public class MockReward implements Reward, Serializable {


    @Serial
    private static final long serialVersionUID = -3565415859459717798L;
    private final long mock;

    public MockReward() {
        this.mock = 5;
    }

    public String toString() {
        return Long.toString(mock);
    }
}
