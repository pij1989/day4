package com.pozharsky.dmitri.service;

import com.pozharsky.dmitri.entity.IntegerArray;
import com.pozharsky.dmitri.entity.JaggedIntegerArray;
import com.pozharsky.dmitri.entity.Order;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class JaggedIntegerArrayServiceTest {
    JaggedIntegerArray jaggedIntegerArray;
    JaggedIntegerArrayService jaggedIntegerArrayService;
    IntegerArrayService integerArrayService;
    IntegerArray integerArray1;
    IntegerArray integerArray2;
    IntegerArray integerArray3;
    IntegerArray integerArray4;
    IntegerArray integerArray5;


    @BeforeMethod
    public void setUp() {
        jaggedIntegerArrayService = new JaggedIntegerArrayService();
        integerArrayService = new IntegerArrayService();
        integerArray1 = new IntegerArray(2, 74, 57, 30, 72, 43, 67);
        integerArray2 = new IntegerArray(5, 49, 48, 37, 79);
        integerArray3 = new IntegerArray(20, 94, 90);
        integerArray4 = new IntegerArray(7, 88, 29, 25, 8, 18, 48, 22, 53, 90);
        integerArray5 = new IntegerArray(62, 10);
        jaggedIntegerArray = new JaggedIntegerArray(integerArray1, integerArray2, integerArray3, integerArray4, integerArray5);
    }

    @AfterMethod
    public void tearDown() {
        jaggedIntegerArray = null;
        jaggedIntegerArrayService = null;
        integerArrayService = null;
        integerArray1 = null;
        integerArray2 = null;
        integerArray3 = null;
        integerArray4 = null;
        integerArray5 = null;
    }

    @Test
    public void testBubleSortByMaxElementInLineAndAscendingOrder() {
        jaggedIntegerArrayService.bubleSortByMaxElementInLine(jaggedIntegerArray, Order.ASCENDING, integerArrayService);
        JaggedIntegerArray actual = jaggedIntegerArray;
        JaggedIntegerArray expect = new JaggedIntegerArray(integerArray5, integerArray1, integerArray2, integerArray4, integerArray3);
        assertEquals(actual, expect);
    }

    @Test
    public void testBubleSortByMaxElementInLineAndDescendingOrder() {
        jaggedIntegerArrayService.bubleSortByMaxElementInLine(jaggedIntegerArray, Order.DESCENDING, integerArrayService);
        JaggedIntegerArray actual = jaggedIntegerArray;
        JaggedIntegerArray expect = new JaggedIntegerArray(integerArray3, integerArray4, integerArray2, integerArray1, integerArray5);
        assertEquals(actual, expect);
    }

    @Test
    public void testBubleSortByMinElementInLineAndAscendingOrder() {
        jaggedIntegerArrayService.bubleSortByMinElementInLine(jaggedIntegerArray, Order.ASCENDING, integerArrayService);
        JaggedIntegerArray actual = jaggedIntegerArray;
        JaggedIntegerArray expect = new JaggedIntegerArray(integerArray1, integerArray2, integerArray4, integerArray5, integerArray3);
        assertEquals(actual, expect);
    }

    @Test
    public void testBubleSortByMinElementInLineAndDescendingOrder() {
        jaggedIntegerArrayService.bubleSortByMinElementInLine(jaggedIntegerArray, Order.DESCENDING, integerArrayService);
        JaggedIntegerArray actual = jaggedIntegerArray;
        JaggedIntegerArray expect = new JaggedIntegerArray(integerArray3, integerArray5, integerArray4, integerArray2, integerArray1);
        assertEquals(actual, expect);
    }

    @Test
    public void testBubleSortBySumElementInLineAndAscendingOrder() {
        jaggedIntegerArrayService.bubleSortBySumElementInLine(jaggedIntegerArray, Order.ASCENDING);
        JaggedIntegerArray actual = jaggedIntegerArray;
        JaggedIntegerArray expect = new JaggedIntegerArray(integerArray5, integerArray3, integerArray2, integerArray1, integerArray4);
        assertEquals(actual, expect);
    }

    @Test
    public void testBubleSortBySumElementInLineAndDescendingOrder() {
        jaggedIntegerArrayService.bubleSortBySumElementInLine(jaggedIntegerArray, Order.DESCENDING);
        JaggedIntegerArray actual = jaggedIntegerArray;
        JaggedIntegerArray expect = new JaggedIntegerArray(integerArray4, integerArray1, integerArray2, integerArray3, integerArray5);
        assertEquals(actual, expect);
    }
}
