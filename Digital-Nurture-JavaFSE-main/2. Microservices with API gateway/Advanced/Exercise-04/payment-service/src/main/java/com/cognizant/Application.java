package com.cognizant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) { SpringApplication.run(Application.class, args); }
    
    @GetMapping("/payment")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackPayment")
    public String processPayment() {
        throw new RuntimeException("Third party API is slow/down!");
    }
    
    public String fallbackPayment(Throwable t) {
        return "Fallback: Payment gateway is currently unavailable. Please try again later.";
    }
}