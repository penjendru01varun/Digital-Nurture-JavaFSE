package com.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("An error occurred during calculation", e);
        }
    }
}
