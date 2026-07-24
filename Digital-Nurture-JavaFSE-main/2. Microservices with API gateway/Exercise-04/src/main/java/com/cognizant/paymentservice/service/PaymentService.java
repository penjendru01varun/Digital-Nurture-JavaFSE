package com.cognizant.paymentservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);

    private final ThirdPartyApiService thirdPartyApiService;

    public PaymentService(ThirdPartyApiService thirdPartyApiService) {
        this.thirdPartyApiService = thirdPartyApiService;
    }

    @CircuitBreaker(name = "paymentCircuitBreaker", fallbackMethod = "paymentFallback")
    public String processPayment(String orderId) {
        LOG.info("Processing payment for order: {}", orderId);
        String apiResponse = thirdPartyApiService.callUnstableApi();
        LOG.info("Payment processed successfully for order: {}", orderId);
        return "PAYMENT_SUCCESS for order " + orderId + " | API: " + apiResponse;
    }

    public String paymentFallback(String orderId, Throwable t) {
        LOG.error("Fallback triggered for order: {}. Reason: {}", orderId, t.getMessage());
        return "PAYMENT_FALLBACK for order " + orderId + " | Please retry later";
    }
}
