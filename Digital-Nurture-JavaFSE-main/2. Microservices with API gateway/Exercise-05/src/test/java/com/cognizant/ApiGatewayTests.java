package com.cognizant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ApiGatewayTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testFallbackTriggered() {
        webTestClient.get().uri("/accounts/00987987973432")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("fallback")
                .jsonPath("$.message").isEqualTo("Account service is temporarily down or slow. Please try again later.");
    }
}
