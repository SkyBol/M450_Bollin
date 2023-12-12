package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
/**
 * Tests f�r die Klasse 'Bank'.
 *
 * @author xxxx
 * @version 1.0
 */
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
    }
    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    @Order(2)
    public void testDeposit() {
        bank.deposit("1", now(), )
    }
    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    @Order(3)
    public void testWithdraw() {
        fail("toDo");
    }

    /**
     * Experimente mit print().
     */
    @Test
    @Order(4)
    public void testPrint() {
        fail("toDo");
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    @Order(5)
    public void testMonthlyPrint() {
        fail("toDo");
    }

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    public void testBalance() {
        fail("toDo");
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testTop5() {
        fail("toDo");
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testBottom5() {
        fail("toDo");
    }

}
