package com.varun.smc.impl;

import com.varun.smc.CountMinSketch;

public class CountMinSketchImpl<T> implements CountMinSketch<T> {

    private final int numberOfHashes;

    private final int numberOfBuckets;

    private final int[][] countMatrix;

    public CountMinSketchImpl(int numberOfHashes, int numberOfBuckets) {
        this.numberOfHashes = numberOfHashes;
        this.numberOfBuckets = numberOfBuckets;
        this.countMatrix = new int[numberOfHashes][numberOfBuckets];
    }

    /**
     * This function increments the count at the index corresponding for every
     * hash function.
     * <p>
     * Different hash functions are generated by appending the
     * index to the key and then taking the hash code of the resulting string.
     */
    @Override
    public void increment(T key) {
        for (int i = 0; i < numberOfHashes; i++) {
            int hash = (key.toString() + i).hashCode();
            int index = Math.abs(hash % numberOfBuckets);
            countMatrix[i][index]++;
        }
    }

    /**
     * This function returns the minimum count for the key by iterating over all
     * the hash functions and finding the minimum count.
     * Hence, the name as Count-Min Sketch.
     */
    @Override
    public int getCount(T key) {
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < numberOfHashes; i++) {
            int hash = (key.toString() + i).hashCode();
            int index = Math.abs(hash % numberOfBuckets);
            minCount = Math.min(minCount, countMatrix[i][index]);
        }
        return minCount;
    }
}