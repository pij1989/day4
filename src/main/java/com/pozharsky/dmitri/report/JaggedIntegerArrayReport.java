package com.pozharsky.dmitri.report;

import com.pozharsky.dmitri.entity.JaggedIntegerArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JaggedIntegerArrayReport {
    private static final Logger logger = LogManager.getLogger(JaggedIntegerArray.class);

    public void printJaggedIntegerArray(JaggedIntegerArray integerArrays) {
        logger.info("Jagged array of integers: " + integerArrays);
    }
}
