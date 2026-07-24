package com.bank;

import org.junit.*;
import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount("12345", 1000.0);
    }

    @After
    public void tearDown() {
        account = null;
    }

    @Test
    public void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        account.withdraw(2000.0);
        assertEquals(1000.0, account.getBalance(), 0.001);
    }

    @Test
    public void testGetAccountId() {
        assertEquals("12345", account.getAccountId());
    }
}
