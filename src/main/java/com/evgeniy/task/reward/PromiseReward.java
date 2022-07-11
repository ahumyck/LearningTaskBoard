package com.evgeniy.task.reward;

public class PromiseReward implements Reward{

    private String promise;

    public PromiseReward(String promise) {
        this.promise = promise;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(promise);
    return sb.toString();
    }
}
