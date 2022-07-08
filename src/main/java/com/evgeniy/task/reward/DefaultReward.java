package com.evgeniy.task.reward;

public class DefaultReward<T> implements Reward<T> {
    private final T reward;
    public DefaultReward(T reward) {
        this.reward = reward;
    }

    @Override
    public T getActualReward() {
        return reward;
    }

    /*@Override
    public String toString() {
        return reward;
    }*/
}
