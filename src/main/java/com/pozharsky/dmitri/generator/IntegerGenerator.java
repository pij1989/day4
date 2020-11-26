package com.pozharsky.dmitri.generator;

import java.util.Random;

public class IntegerGenerator {
    private static final int NUMBER_ORIGIN = 0;
    private static final int NUMBER_BOUND = Integer.MAX_VALUE;

    public int[] generateIntegers(int amount) {
        return generateIntegers(amount, NUMBER_ORIGIN, NUMBER_BOUND);
    }

    public int[] generateIntegers(int amount, int numberOrigin, int numberBound) {
        Random random = new Random();
        int[] array = random.ints(numberOrigin, numberBound)
                .limit(amount)
                .toArray();
        return array;
    }
}
