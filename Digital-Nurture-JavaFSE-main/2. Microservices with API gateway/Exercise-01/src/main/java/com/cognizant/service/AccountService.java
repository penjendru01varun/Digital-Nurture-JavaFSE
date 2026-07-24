package com.cognizant.service;

import com.cognizant.model.Account;
import com.cognizant.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccount(String number) {
        LOGGER.info("START getAccount for number: {}", number);
        Account account = accountRepository.findById(number).orElse(null);
        LOGGER.info("END getAccount returning: {}", account);
        return account;
    }
}
