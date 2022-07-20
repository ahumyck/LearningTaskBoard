package com.evgeniy.task;

import com.evgeniy.task.reward.Reward;

import java.io.Serializable;

public class MockReward implements Reward, Serializable {


    private final long mock;

    public MockReward() {
        this.mock = 5;
    }

    public String toString() {
        return Long.toString(mock);
    }
}
