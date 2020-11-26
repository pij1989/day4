package com.pozharsky.dmitri.maker;

import com.pozharsky.dmitri.entity.IntegerArray;
import com.pozharsky.dmitri.generator.IntegerGenerator;
import com.pozharsky.dmitri.reader.IntegerReader;

public class IntegerArrayMaker {
    public IntegerArray makeFromFile(IntegerReader reader, String file) {
        int[] array = reader.readIntegers(file);
        return new IntegerArray(array);
    }

    public IntegerArray makeFromRandomInteger(IntegerGenerator integerGenerator, int amount) {
        int[] array = integerGenerator.generateIntegers(amount);
        return new IntegerArray(array);
    }

    public IntegerArray makeFromRandomInteger(IntegerGenerator integerGenerator, int amount, int numberOrigin, int numberBound) {
        int[] array = integerGenerator.generateIntegers(amount, numberOrigin, numberBound);
        return new IntegerArray(array);
    }
}
