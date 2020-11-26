package com.pozharsky.dmitri.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class IntegerReader {
    private static final Logger logger = LogManager.getLogger(IntegerReader.class);
    private static final String REG_COMMA = ",";
    private static final String DEFAULT_FILE = "data\\integers.txt";
    private static final int EMPTY = 0;

    public int[] readIntegers(String file) {
        if (file == null) {
            file = DEFAULT_FILE;
        }
        File f = new File(file);
        if (f.length() == EMPTY) {
            f = new File(DEFAULT_FILE);
        }
        String line;
        int[] resultArray = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            while ((line = reader.readLine()) != null) {
                int[] intermediateArray = parseIntArray(line);
                if (resultArray == null) {
                    resultArray = intermediateArray;
                } else {
                    resultArray = Stream.of(resultArray, intermediateArray)
                            .flatMapToInt(Arrays::stream)
                            .toArray();
                }
            }
        } catch (FileNotFoundException e) {
            logger.fatal("File is not found: " + e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.fatal("Error of file: " + e);
            throw new RuntimeException(e);
        }
        return resultArray;
    }

    private int[] parseIntArray(String line) {
        String[] arrayString = line.split(REG_COMMA);
        int[] arrayInteger = Arrays.stream(arrayString)
                .mapToInt(e -> Integer.parseInt(e.trim()))
                .toArray();
        return arrayInteger;
    }
}
