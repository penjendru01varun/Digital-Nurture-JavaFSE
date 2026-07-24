package com.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String userName = "Alice";
        int userId = 101;
        double balance = 2500.50;

        logger.info("User {} with ID {} has a balance of ${}", userName, userId, balance);

        int orderCount = 5;
        String status = "completed";
        logger.info("User {} has {} orders with status {}", userName, orderCount, status);
    }
}
