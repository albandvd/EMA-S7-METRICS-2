package bankAccountApp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {

    private Bank bank;
    private BankAccount acc1;
    private BankAccount acc2;

    @BeforeEach
    void setUp() {
        bank = new Bank();

        acc1 = new BankAccount();
        acc2 = new BankAccount();

        acc1.deposit(100);
        acc2.deposit(200);

        bank.addAccount(acc1, 0);
        bank.addAccount(acc2, 0);
    }

    // ================= Happy Path =================
    @Test
    void findAccount_existingAccount_returnsCorrectAccount() {
        BankAccount found = bank.findAccount(acc1.getAccountNumber());
        assertNotNull(found);
        assertEquals(100, found.getBalance());
    }

    @Test
    void getAverageBalance_returnsCorrectAverage() {
        double average = bank.getAverageBalance();
        assertEquals(150.0, average);
    }

    // ================= Edge Cases =================
    @Test
    void findAccount_nonExistingAccount_returnsNull() {
        BankAccount found = bank.findAccount(9999);
        assertNull(found);
    }

    @Test
    void deposit_negativeAmount_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> acc1.deposit(-50));
    }

    @Test
    void withdraw_moreThanBalance_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> acc1.withdraw(500));
    }

    @Test
    void withdraw_negativeAmount_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> acc1.withdraw(-20));
    }
}
