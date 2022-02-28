import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccountWithATM implementation
 */
public class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest {

    @BeforeEach
    void bankAccountATMInit(){
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void TestATMDeposit(){
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void TestATMWithdraw(){
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 30);
        assertEquals(68, bankAccount.getBalance());
    }

}
