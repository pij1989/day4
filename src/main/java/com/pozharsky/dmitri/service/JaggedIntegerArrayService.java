package com.pozharsky.dmitri.service;

import com.pozharsky.dmitri.comparator.IntegerComparator;
import com.pozharsky.dmitri.entity.Operation;
import com.pozharsky.dmitri.entity.IntegerArray;
import com.pozharsky.dmitri.entity.JaggedIntegerArray;
import com.pozharsky.dmitri.entity.Order;
import com.pozharsky.dmitri.exception.JaggedIntegerArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;

public class JaggedIntegerArrayService {
    private static final Logger logger = LogManager.getLogger(JaggedIntegerArrayService.class);

    public void bubleSortByMaxElementInLine(JaggedIntegerArray jaggedIntegerArray, Order order, IntegerArrayService integerArrayService) {
        int[] array = defineArrayByElement(jaggedIntegerArray, integerArrayService, Operation.MAX);
        sortByOrder(jaggedIntegerArray, array, order);
    }

    public void bubleSortByMinElementInLine(JaggedIntegerArray jaggedIntegerArray, Order order, IntegerArrayService integerArrayService) {
        int[] array = defineArrayByElement(jaggedIntegerArray, integerArrayService, Operation.MIN);
        sortByOrder(jaggedIntegerArray, array, order);
    }

    public void bubleSortBySumElementInLine(JaggedIntegerArray jaggedIntegerArray, Order order) {
        int[] array = defineArrayByElement(jaggedIntegerArray, null, Operation.SUM);
        sortByOrder(jaggedIntegerArray, array, order);
    }

    private void bubleSort(int[] array, JaggedIntegerArray jaggedIntegerArray, Comparator<Integer> comparator) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                    swap(jaggedIntegerArray, j, j + 1);
                }
            }
        }
    }

    private void sortByOrder(JaggedIntegerArray jaggedIntegerArray, int[] array, Order order) {
        Comparator<Integer> comparator = new IntegerComparator();
        switch (order) {
            case ASCENDING: {
                bubleSort(array, jaggedIntegerArray, comparator);
                break;
            }
            case DESCENDING: {
                bubleSort(array, jaggedIntegerArray, comparator.reversed());
                break;
            }
            default: {
                String msg = "Unknown order value " + order;
                logger.fatal(msg);
                throw new IllegalStateException(msg);
            }
        }
    }

    private int[] defineArrayByElement(JaggedIntegerArray jaggedIntegerArray, IntegerArrayService integerArrayService, Operation operation) {
        int size = jaggedIntegerArray.getSize();
        int[] array = new int[size];
        try {
            switch (operation) {
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
                    String msg = "Unknown element value " + operation;
                    logger.fatal(msg);
                    throw new IllegalStateException(msg);
                }
            }
        } catch (JaggedIntegerArrayException e) {
            logger.fatal("Incorrect range of index: " + e);
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
