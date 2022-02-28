import lab01.example.model.AbstractBankAccount;
import lab01.example.model.AccountHolder;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the AbstractBankAccount implementation
 */
public abstract class AbstractBankAccountTest {
    protected AccountHolder accountHolder;
    protected AbstractBankAccount bankAccount;

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
    }

    @Test
    void TestInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void TestWrongDeposit() {
        bankAccount.deposit(2, 100);
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void TestWrongWithdraw() {
        bankAccount.withdraw(accountHolder.getId(), 100);
        assertEquals(0, bankAccount.getBalance());
    }
}
