package com.pozharsky.dmitri.entity;

import com.pozharsky.dmitri.exception.IntegerArrayException;

import java.util.Arrays;
import java.util.List;

public class IntegerArray {
    private static final int DEFAULT_CAPACITY = 0;
    private int[] array;

    public IntegerArray() {
        this.array = new int[DEFAULT_CAPACITY];
    }

    public IntegerArray(int... integers) {
        this.array = integers;
    }

    public IntegerArray(List<Integer> list) {
        this.array = list.stream()
                .mapToInt(e -> e)
                .toArray();
    }

    public int getInteger(int index) throws IntegerArrayException {
        if (index < 0 || index >= array.length) {
            throw new IntegerArrayException("Index less then zero or more then size of integer array");
        }
        return array[index];
    }

    public void setInteger(int index, int value) throws IntegerArrayException {
        if (index < 0 || index >= array.length) {
            throw new IntegerArrayException("Index less then zero or more then size of integer array");
        }
        array[index] = value;
    }

    public void addInteger(int value) {
        int size = array.length;
        array = Arrays.copyOf(array, size + 1);
        array[size] = value;
    }

    public int removeInteger(int index) throws IntegerArrayException {
        if (index < 0 || index >= array.length) {
            throw new IntegerArrayException("Index less then zero or more then size of integer array");
        }
        int value = array[index];
        int newSize = array.length - 1;
        int[] newArray = new int[newSize];
        System.arraycopy(array, index + 1, newArray, index, newSize - index);
        System.arraycopy(array, 0, newArray, 0, index);
        array = newArray;
        return value;
    }

    public int getSize() {
        return array.length;
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntegerArray that = (IntegerArray) o;

        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IntegerArray{");
        sb.append("array=").append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }
}
