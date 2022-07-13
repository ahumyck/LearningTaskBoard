package com.evgeniy.task.reward;

public class PromiseReward implements Reward{

    private String promise;

    public PromiseReward(String promise) {
        this.promise = promise;
    }

    public String toString() {
    return promise;
    }
}