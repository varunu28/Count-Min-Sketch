package com.varun.smc;

public interface CountMinSketch<T> {

    /**
     * Increments the count for the given key
     *
     * @param key the key for which we want to increment the count
     */
    void increment(T key);

    /**
     * Returns the count for the given key
     *
     * @param key the key for which we want to get the count
     * @return the count for the given key
     */
    int getCount(T key);
}
