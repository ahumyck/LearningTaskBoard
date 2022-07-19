package com.evgeniy.task.reward;

public class MockReward implements Reward {


    private final long mock;

    public MockReward() {
        this.mock = 5;
    }

    public String toString() {
        return Long.toString(mock);
    }
}
