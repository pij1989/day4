package com.pozharsky.dmitri.service;

import com.pozharsky.dmitri.entity.Element;
import com.pozharsky.dmitri.entity.IntegerArray;
import com.pozharsky.dmitri.entity.JaggedIntegerArray;
import com.pozharsky.dmitri.entity.Order;
import com.pozharsky.dmitri.exception.JaggedIntegerArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class JaggedIntegerArrayService {
    private static final Logger logger = LogManager.getLogger(JaggedIntegerArrayService.class);

    public void bubleSortByMaxElementInLine(JaggedIntegerArray jaggedIntegerArray, Order order, IntegerArrayService integerArrayService) {
        int[] array = defineArrayByElement(jaggedIntegerArray, integerArrayService, Element.MAX);
        sortByOrder(jaggedIntegerArray, array, order);
    }

    public void bubleSortByMinElementInLine(JaggedIntegerArray jaggedIntegerArray, Order order, IntegerArrayService integerArrayService) {
        int[] array = defineArrayByElement(jaggedIntegerArray, integerArrayService, Element.MIN);
        sortByOrder(jaggedIntegerArray, array, order);
    }

    public void bubleSortBySumElementInLine(JaggedIntegerArray jaggedIntegerArray, Order order) {
        int[] array = defineArrayByElement(jaggedIntegerArray, null, Element.SUM);
        sortByOrder(jaggedIntegerArray, array, order);
    }

    private void bubleSortAsc(int[] array, JaggedIntegerArray jaggedIntegerArray) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swap(jaggedIntegerArray, j, j + 1);
                }
            }
        }
    }

    private void bubleSortDesc(int[] array, JaggedIntegerArray jaggedIntegerArray) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1]) {
                    swap(array, j, j + 1);
                    swap(jaggedIntegerArray, j, j + 1);
                }
            }
        }
    }

    private void sortByOrder(JaggedIntegerArray jaggedIntegerArray, int[] array, Order order) {
        switch (order) {
            case ASCENDING: {
                bubleSortAsc(array, jaggedIntegerArray);
                break;
            }
            case DESCENDING: {
                bubleSortDesc(array, jaggedIntegerArray);
                break;
            }
            default: {
                String msg = "Unknown order value " + order;
                logger.fatal(msg);
                throw new IllegalStateException(msg);
            }
        }
    }

    private int[] defineArrayByElement(JaggedIntegerArray jaggedIntegerArray, IntegerArrayService integerArrayService, Element element) {
        int size = jaggedIntegerArray.getSize();
        int[] array = new int[size];
        try {
            switch (element) {
                case SUM: {
                    for (int i = 0; i < size; i++) {
                        IntegerArray integerArray = jaggedIntegerArray.getIntegerArray(i);
                        int result = Arrays.stream(integerArray.getArray()).sum();
                        array[i] = result;
                    }
                    break;
                }
                case MAX: {
                    for (int i = 0; i < size; i++) {
                        IntegerArray integerArray = jaggedIntegerArray.getIntegerArray(i);
                        array[i] = integerArrayService.max(integerArray);
                    }
                    break;
                }
                case MIN: {
                    for (int i = 0; i < size; i++) {
                        IntegerArray integerArray = jaggedIntegerArray.getIntegerArray(i);
                        array[i] = integerArrayService.min(integerArray);
                    }
                    break;
                }
                default: {
                    String msg = "Unknown element value " + element;
                    logger.fatal(msg);
                    throw new IllegalStateException(msg);
                }
            }
        } catch (JaggedIntegerArrayException e) {
            logger.fatal(e);
            throw new RuntimeException();
        }
        return array;
    }

    private void swap(JaggedIntegerArray integerArrays, int previousIndex, int nextIndex) {
        try {
            IntegerArray previous = integerArrays.getIntegerArray(previousIndex);
            IntegerArray next = integerArrays.getIntegerArray(nextIndex);
            integerArrays.setIntegerArray(previousIndex, next);
            integerArrays.setIntegerArray(nextIndex, previous);
        } catch (JaggedIntegerArrayException e) {
            logger.error(e);
        }
    }

    private void swap(int[] array, int previousIndex, int nextIndex) {
        int temp = array[previousIndex];
        array[previousIndex] = array[nextIndex];
        array[nextIndex] = temp;
    }
}
