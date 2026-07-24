package com.cognizant.controller;

import com.cognizant.feign.LoanClient;
import com.cognizant.model.Account;
import com.cognizant.model.Loan;
import com.cognizant.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    private final AccountService accountService;
    private final LoanClient loanClient;

    public AccountController(AccountService accountService, LoanClient loanClient) {
        this.accountService = accountService;
        this.loanClient = loanClient;
    }

    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable String number) {
        LOGGER.info("START getAccount for number: {}", number);
        Account account = accountService.getAccount(number);
        LOGGER.info("END getAccount returning: {}", account);
        return account;
    }

    @GetMapping("/accounts/{number}/details")
    public Map<String, Object> getAccountWithLoan(@PathVariable String number) {
        LOGGER.info("START getAccountWithLoan for number: {}", number);
        Account account = accountService.getAccount(number);
        Loan loan = loanClient.getLoan(number);
        LOGGER.info("END getAccountWithLoan returning account: {}, loan: {}", account, loan);
        return Map.of("account", account, "loan", loan);
    }
}
