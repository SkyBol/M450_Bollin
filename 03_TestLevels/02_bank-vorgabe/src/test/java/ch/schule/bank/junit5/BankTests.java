package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests f�r die Klasse 'Bank'.
 *
 * @author me
 * @version 1.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankTests {
    private Bank bank;

    private int now() {
        return (int)(new Date().getTime()/1000);
    }


    /**
     * Tests to create new Accounts
     */
    @Test
    @Order(1)
    public void testCreate() {
        bank = new Bank();
        bank.createSavingsAccount();
        bank.createPromoYouthSavingsAccount();
        bank.createSalaryAccount(-10000);
        assertNull(bank.createSalaryAccount(100));
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    @Order(2)
    public void testDeposit() {
        // Savings Account
        assertTrue(bank.deposit("S-1000", now(), 2000));
        assertFalse(bank.deposit("S-1000", now(), -200));

        // Youth Savings Account
        assertTrue(bank.deposit("Y-1001", now(), 3500));
        assertFalse(bank.deposit("Y-1001", now(), -600));

        // Salary Account
        assertTrue(bank.deposit("P-1002", now(), 2000));
        assertFalse(bank.deposit("P-1002", now(), -150));

        // Non Existent
        assertFalse(bank.deposit("404", now(), 1000));
    }
    /**
     * Testet das Abheben von einem Konto.
     */

    @Test
    @Order(3)
    public void testWithdraw() {
        // Savings Account
        assertTrue(bank.withdraw("S-1000", now(), 500));
        assertFalse(bank.withdraw("S-1000", now(), -250));
        assertFalse(bank.withdraw("S-1000", now(), 10_000));

        // Salary Account
        assertTrue(bank.withdraw("P-1002", now(), 500));
        assertFalse(bank.withdraw("P-1002", now(), -250));
        assertFalse(bank.withdraw("P-1002", now(), 500_000));

        // Non Existent
        assertFalse(bank.withdraw("404", now(), 1000));
    }

    /**
     * Experimente mit print().
     */
    @Test
    @Order(4)
    public void testPrint() {
        assertAll(() -> bank.print("S-1000"));
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    @Order(5)
    public void testMonthlyPrint() {
        assertAll(() -> bank.print("S-1000", 2023, 5));
    }

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    @Order(6)
    public void testBalance() {
        assertEquals(bank.getBalance("SomeIdWhichDoesntExist"), 0);
        assertEquals(bank.getBalance("S-1000"), 1500);
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    @Order(7)
    public void testTop5() {
        assertAll(() -> bank.printTop5());
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    @Order(8)
    public void testBottom5() {
        assertAll(() -> bank.printBottom5());
    }

    @Test
    @Order(100)
    public void gettersAndSetters() {
        assertAll(() -> bank.getBalance());
        assertAll(() -> bank.getAccount());
        assertAll(() -> bank.setAccount(null));
    }
}
