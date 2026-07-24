package com.cognizant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) { SpringApplication.run(Application.class, args); }
    @Bean public WebClient.Builder webClientBuilder() { return WebClient.builder(); }
    private final WebClient.Builder webClientBuilder;
    public Application(WebClient.Builder webClientBuilder) { this.webClientBuilder = webClientBuilder; }
    
    @GetMapping("/orders")
    public String getOrders() {
        String user = webClientBuilder.build().get().uri("http://localhost:8081/users/1").retrieve().bodyToMono(String.class).block();
        return "Order for " + user;
    }
}