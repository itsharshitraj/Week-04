package testingbankingtransaction;
import junit.testingbankingtransaction.BankAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(100.0); // Initial balance of 100
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(50.0);
        assertEquals(150.0, bankAccount.getBalance(), 0.001);
    }

    @Test
    void testWithdraw() {
        bankAccount.withdraw(30.0);
        assertEquals(70.0, bankAccount.getBalance(), 0.001);
    }

    @Test
    void testWithdrawInsufficientFunds() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(200.0));
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void testNegativeDeposit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-10.0));
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }

    @Test
    void testNegativeWithdrawal() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-5.0));
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }

    @Test
    void testInitialNegativeBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new BankAccount(-50.0));
        assertEquals("Initial balance cannot be negative", exception.getMessage());
    }
}
