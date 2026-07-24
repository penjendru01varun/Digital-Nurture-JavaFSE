package com.cognizant.service;

import com.cognizant.model.Loan;
import com.cognizant.repository.LoanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanService.class);

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan getLoan(String number) {
        LOGGER.info("START getLoan for number: {}", number);
        Loan loan = loanRepository.findById(number).orElse(null);
        LOGGER.info("END getLoan returning: {}", loan);
        return loan;
    }
}
