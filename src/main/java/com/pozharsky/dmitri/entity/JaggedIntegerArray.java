package com.pozharsky.dmitri.entity;

import com.pozharsky.dmitri.exception.JaggedIntegerArrayException;

import java.util.Arrays;

public class JaggedIntegerArray {
    private IntegerArray[] integerArrays;

    public JaggedIntegerArray(IntegerArray... integerArrays) {
        this.integerArrays = integerArrays;
    }

    public IntegerArray getIntegerArray(int index) throws JaggedIntegerArrayException {
        if (index < 0 || index >= integerArrays.length) {
            throw new JaggedIntegerArrayException("Index less then zero or more then size of jagged integer array");
        }
        return integerArrays[index];
    }

    public void setIntegerArray(int index, IntegerArray value) throws JaggedIntegerArrayException {
        if (index < 0 || index >= integerArrays.length) {
            throw new JaggedIntegerArrayException("Index less then zero or more then size of jagged integer array");
        }
        integerArrays[index] = value;
    }

    public int getSize(){
        return integerArrays.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JaggedIntegerArray that = (JaggedIntegerArray) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(integerArrays, that.integerArrays);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(integerArrays);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JaggedIntegerArray{");
        sb.append("integerArrays=").append(Arrays.toString(integerArrays));
        sb.append('}');
        return sb.toString();
    }
}
