package com.cognizant.paymentservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyApiService {

    private static final Logger LOG = LoggerFactory.getLogger(ThirdPartyApiService.class);

    public String callSlowApi() {
        LOG.info("Calling slow third-party API...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        LOG.info("Slow API responded successfully");
        return "API_RESPONSE_SUCCESS";
    }

    public String callUnstableApi() {
        LOG.info("Calling unstable third-party API...");
        if (Math.random() < 0.6) {
            LOG.warn("Unstable API failed with random error");
            throw new RuntimeException("Third-party API random failure");
        }
        LOG.info("Unstable API responded successfully");
        return "API_RESPONSE_SUCCESS";
    }
}
