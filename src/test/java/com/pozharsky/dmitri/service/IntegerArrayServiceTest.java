package com.pozharsky.dmitri.service;

import com.pozharsky.dmitri.entity.IntegerArray;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class IntegerArrayServiceTest {
    IntegerArrayService integerArrayService;
    IntegerArray integerArray;

    @BeforeMethod
    public void setUp() {
        integerArrayService = new IntegerArrayService();
        integerArray = new IntegerArray(13, 5, 8, 831, 287, 775, 557, 31, 21);
    }

    @AfterMethod
    public void tearDown() {
        integerArrayService = null;
        integerArray = null;
    }

    @Test
    public void testQuickSort() {
        integerArrayService.quickSort(integerArray);
        IntegerArray actual = integerArray;
        IntegerArray expect = new IntegerArray(5, 8, 13, 21, 31, 287, 557, 775, 831);
        assertEquals(actual, expect);
    }

    @Test
    public void testBubleSort() {
        integerArrayService.bubleSort(integerArray);
        IntegerArray actual = integerArray;
        IntegerArray expect = new IntegerArray(5, 8, 13, 21, 31, 287, 557, 775, 831);
        assertEquals(actual, expect);
    }

    @Test
    public void testMergeSort() {
        integerArrayService.mergeSort(integerArray);
        IntegerArray actual = integerArray;
        IntegerArray expect = new IntegerArray(5, 8, 13, 21, 31, 287, 557, 775, 831);
        assertEquals(actual, expect);
    }

    @Test
    public void testBinarySearch() {
        integerArrayService.mergeSort(integerArray);
        int actual = integerArrayService.binarySearch(integerArray, 21);
        int expect = 3;
        assertEquals(actual, expect);
    }

    @Test
    public void testMax() {
        int actual = integerArrayService.max(integerArray);
        int expect = 831;
        assertEquals(actual, expect);
    }

    @Test
    public void testMin() {
        int actual = integerArrayService.min(integerArray);
        int expect = 5;
        assertEquals(actual, expect);
    }

    @Test
    public void testPrimeNumbers() {
        List<Integer> actual = integerArrayService.primeNumbers(integerArray);
        List<Integer> expect = List.of(13, 5, 557, 31);
        assertEquals(actual, expect);
    }

    @Test
    public void testFibonaciNumbers() {
        List<Integer> actual = integerArrayService.fibonaciNumbers(integerArray);
        List<Integer> expect = List.of(13, 5, 8, 21);
        assertEquals(actual, expect);
    }

    @Test
    public void testDefineThreeDigitNumberWithoutSameDigit() {
        List<Integer> actual = integerArrayService.defineThreeDigitNumberWithoutSameDigit(integerArray);
        List<Integer> expect = List.of(831, 287);
        assertEquals(actual, expect);
    }
}