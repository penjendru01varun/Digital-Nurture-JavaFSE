package com.cognizant.feign;

import com.cognizant.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "loan-service", url = "http://localhost:8081")
public interface LoanClient {

    @GetMapping("/loans/{number}")
    Loan getLoan(@PathVariable("number") String number);
}
