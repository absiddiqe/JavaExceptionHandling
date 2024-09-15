// BankAccountTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        // Create a BankAccount object with an initial balance of $100 before each test
        account = new BankAccount("12345", 100.0);
    }

    @Test
    void testDepositValidAmount() {
        // Test deposit with a valid amount
        try {
            account.deposit(50.0);
        } catch (InvalidAmountException e) {
            fail("Exception should not have been thrown for a valid deposit.");
        }
        assertEquals(150.0, account.getBalance(), "Balance should be 150.0 after depositing 50.0");
    }

    @Test
    void testDepositInvalidAmount() {
        // Test deposit with an invalid amount (-10.0)
        Exception exception = assertThrows(InvalidAmountException.class, () -> {
            account.deposit(-10.0);
        });
        assertEquals("Invalid amount! Deposit amount must be greater than zero.", exception.getMessage());
    }

    @Test
    void testWithdrawValidAmount() {
        // Test withdraw with a valid amount
        try {
            account.withdraw(50.0);
        } catch (InsufficientFundsException e) {
            fail("Exception should not have been thrown for a valid withdrawal.");
        }
        assertEquals(50.0, account.getBalance(), "Balance should be 50.0 after withdrawing 50.0");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        // Test withdraw with an amount greater than the balance
        Exception exception = assertThrows(InsufficientFundsException.class, () -> {
            account.withdraw(200.0);
        });
        assertEquals("Insufficient funds! Cannot withdraw $200.0", exception.getMessage());
    }

    @Test
    void testWithdrawInvalidAmount() {
        // Test withdraw with an invalid amount (-20.0)
        Exception exception = assertThrows(InvalidAmountException.class, () -> {
            account.withdraw(-20.0);
        });
        assertEquals("Invalid amount! Withdrawal amount must be greater than zero.", exception.getMessage());
    }
}
