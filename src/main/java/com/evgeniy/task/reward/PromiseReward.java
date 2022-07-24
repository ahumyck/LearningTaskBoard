package com.evgeniy.task.reward;

import java.io.Serial;
import java.io.Serializable;

public class PromiseReward implements Reward, Serializable {

    @Serial
    private static final long serialVersionUID = 4594897388344065467L;
    private String promise;

    public PromiseReward(String promise) {
        this.promise = promise;
    }

    public String toString() {
    return promise;
    }
}
