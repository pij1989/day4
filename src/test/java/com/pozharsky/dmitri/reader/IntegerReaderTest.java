package com.pozharsky.dmitri.reader;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IntegerReaderTest {
    static final String FILE = "src\\test\\resources\\test_integers.txt";
    IntegerReader integerReader;

    @BeforeMethod
    public void setUp() {
        integerReader = new IntegerReader();
    }

    @AfterMethod
    public void tearDown() {
        integerReader = null;
    }

    @Test
    public void testReadIntegers() {
        int[] actual = integerReader.readIntegers(FILE);
        int[] expect = new int[]{1, 2, 30, 40, 60, 70, 3, 75, 9, 8, 7, 5};
        assertEquals(actual, expect);
    }
}
