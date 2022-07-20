package com.evgeniy.task.reward;

import java.io.Serializable;

public class PromiseReward implements Reward, Serializable {

    private String promise;

    public PromiseReward(String promise) {
        this.promise = promise;
    }

    public String toString() {
    return promise;
    }
}
