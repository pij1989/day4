package com.pozharsky.dmitri.report;

import com.pozharsky.dmitri.entity.IntegerArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntegerArrayReport {
    private static final Logger logger = LogManager.getLogger(IntegerArrayReport.class);

    public void printIntegerArray(IntegerArray integerArray) {
        logger.info("Array of integers: " + integerArray);
    }
}
