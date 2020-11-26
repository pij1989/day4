package com.pozharsky.dmitri.service;

import com.pozharsky.dmitri.entity.IntegerArray;
import com.pozharsky.dmitri.exception.IntegerArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class IntegerArrayService {
    private static final Logger logger = LogManager.getLogger(IntegerArrayService.class);

    public void quickSort(IntegerArray integerArray) {
        int[] array = integerArray.getArray();
        quickSort(array, 0, array.length - 1);
        setIntegerArray(integerArray, array);
    }

    public void bubleSort(IntegerArray integerArray) {
        int[] array = integerArray.getArray();
        bubleSort(array);
        setIntegerArray(integerArray, array);
    }

    public void mergeSort(IntegerArray integerArray) {
        int[] array = integerArray.getArray();
        mergeSort(array, 0, array.length - 1);
        setIntegerArray(integerArray, array);
    }

    public int binarySearch(IntegerArray integerArray, int key) {
        int[] array = integerArray.getArray();
        return binarySearch(array, 0, array.length - 1, key);
    }

    public int max(IntegerArray integerArray) {
        int[] array = integerArray.getArray();
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int min(IntegerArray integerArray) {
        int[] array = integerArray.getArray();
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public List<Integer> primeNumbers(IntegerArray integerArray) {
        List<Integer> list = new LinkedList<>();
        int[] array = integerArray.getArray();
        for (int number : array) {
            boolean isPrime = true;
            int count = 2;
            while (count < number) {
                if (number % count == 0) {
                    isPrime = false;
                    break;
                }
                count++;
            }
            if (isPrime) {
                list.add(number);
            }
        }
        return list;
    }

    public List<Integer> fibonaciNumbers(IntegerArray integerArray) {
        List<Integer> list = new LinkedList<>();
        int[] array = integerArray.getArray();
        for (int number : array) {
            int one = 5 * number * number + 4;
            int two = 5 * number * number - 4;
            int a = (int) Math.sqrt(one);
            int b = (int) Math.sqrt(two);
            if (a * a == one || b * b == two) {
                list.add(number);
            }
        }
        return list;
    }

    public List<Integer> defineThreeDigitNumberWithoutSameDigit(IntegerArray integerArray) {
        List<Integer> list = new LinkedList<>();
        int[] array = integerArray.getArray();
        for (int number : array) {
            boolean flag = true;
            String s = String.valueOf(Math.abs(number));
            if (s.length() != 3) {
                continue;
            }
            char[] chars = s.toCharArray();
            int count = 0;
            while (count < chars.length) {
                if (s.indexOf(chars[count]) != s.lastIndexOf(chars[count])) {
                    flag = false;
                    break;
                }
                count++;
            }
            if (flag) {
                list.add(number);
            }
        }
        return list;
    }

    private int binarySearch(int[] array, int start, int end, int key) {
        int low = start;
        int high = end;

        while (low <= high) {
            int mid = (low + high) / 2;
            int middle = array[mid];

            if (middle < key)
                low = mid + 1;
            else if (middle > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    private void mergeSort(int[] array, int start, int end) {
        if (end <= start) return;
        int middle = start + (end - start) / 2;
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);
        merge(array, start, middle, end);
    }

    private static void merge(int[] array, int start, int middle, int end) {
        int[] arrayBuffer = new int[array.length];
        int i = start;
        int j = middle + 1;
        for (int k = start; k <= end; k++) {
            arrayBuffer[k] = array[k];
        }
        for (int k = start; k <= end; k++) {
            if (i > middle) array[k] = arrayBuffer[j++];
            else if (j > end) array[k] = arrayBuffer[i++];
            else if (arrayBuffer[j] < arrayBuffer[i]) array[k] = arrayBuffer[j++];
            else array[k] = arrayBuffer[i++];
        }
    }

    private void bubleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private void quickSort(int[] array, int start, int end) {
        int mid = start + (end - start) / 2;
        int middle = array[mid];
        int i = start;
        int j = end;
        while (i <= j) {
            while (array[i] < middle) {
                i++;
            }
            while (middle < array[j]) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (start < j) {
            quickSort(array, start, j);
        }
        if (end > i) {
            quickSort(array, i, end);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void setIntegerArray(IntegerArray integerArray, int[] array) {
        try {
            for (int i = 0; i < array.length; i++) {
                integerArray.setInteger(i, array[i]);
            }
        } catch (IntegerArrayException e) {
            logger.error(e);
        }
    }
}
