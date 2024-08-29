package com.varun.smc;

import com.varun.smc.impl.CountMinSketchImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountMinSketchTest {

    private CountMinSketch<String> countMinSketch;

    @BeforeEach
    public void setUp() {
        countMinSketch = new CountMinSketchImpl<>(4, 6);
    }

    @Test
    public void incrementAndGet() {
        // Act
        countMinSketch.increment("a");
        countMinSketch.increment("a");

        // Assert
        assertEquals(2, countMinSketch.getCount("a"));
    }

    @Test
    public void incrementAndGetWithDifferentKeys() {
        // Act
        countMinSketch.increment("a");
        countMinSketch.increment("b");

        // Assert
        assertEquals(1, countMinSketch.getCount("a"));
        assertEquals(1, countMinSketch.getCount("b"));
    }

    @Test
    public void incrementAndGetWithDifferentKeysAndMultipleIncrements() {
        // Act
        countMinSketch.increment("a");
        countMinSketch.increment("a");
        countMinSketch.increment("b");
        countMinSketch.increment("b");
        countMinSketch.increment("b");

        // Assert
        assertEquals(2, countMinSketch.getCount("a"));
        assertEquals(3, countMinSketch.getCount("b"));
    }

    @Test
    public void incrementAndGetWithDifferentKeysAndMultipleIncrementsAndDifferentHashes() {
        // Act
        countMinSketch.increment("a");
        countMinSketch.increment("a");
        countMinSketch.increment("b");
        countMinSketch.increment("b");
        countMinSketch.increment("b");
        countMinSketch.increment("c");
        countMinSketch.increment("c");
        countMinSketch.increment("c");
        countMinSketch.increment("c");

        // Assert
        assertEquals(2, countMinSketch.getCount("a"));
        assertEquals(3, countMinSketch.getCount("b"));
        assertEquals(4, countMinSketch.getCount("c"));
    }

    @Test
    public void getCountForNonExistentKey() {
        // Act
        countMinSketch.increment("a");

        // Assert
        assertEquals(0, countMinSketch.getCount("b"));
    }
}