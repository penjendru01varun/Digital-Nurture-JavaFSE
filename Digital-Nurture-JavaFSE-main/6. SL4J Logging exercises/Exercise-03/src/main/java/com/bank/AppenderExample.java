package com.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {

    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message - checking application startup");
        logger.info("Application started successfully");
        logger.warn("Warning: memory usage is above 80%");
        logger.error("Error: unable to connect to database");
    }
}
