package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.SalaryAccount;
import ch.schule.SavingsAccount;
import org.junit.jupiter.api.*;


import java.util.Date;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
/**
 * Tests für die Klasse Account.
 *
 * @author xxxx
 * @version 1.0
 */
public class AccountTests {
    private final TreeMap<String, Account> accounts = new TreeMap<>();

    private int now() {
        return (int)(new Date().getTime()/1000);
    }

    /**
     * Tested die Initialisierung eines Kontos.
     */
    @Test
    @Order(1)
    public void testInit() {
        Account SalaryAccount = new SalaryAccount("1", -10000);
        Account SavingsAccount = new SavingsAccount("2");

        assertNotNull(SalaryAccount);
        assertNotNull(SavingsAccount);

        accounts.put("1", SalaryAccount);
        accounts.put("2", SavingsAccount);
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    @Order(2)
    public void testDeposit() {
        assertTrue(accounts.get("1").deposit(now(), 1000));

        assertFalse(accounts.get("1").deposit(now(), -200));
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    @Order(3)
    public void testWithdraw() {
        assertTrue(accounts.get("1").withdraw(now(), 999));

        assertFalse(accounts.get("1").withdraw(now(), -500));
        assertFalse(accounts.get("1").withdraw(now(), 100000));
    }

    /**
     * Tests the reference from SavingsAccount
     */
    @Test
    @Order(4)
    public void testReferences() {
        //(SavingsAccount)(accounts.get("2")).
    }

    /**
     * teste the canTransact Flag
     */
    @Test
    @Order(5)
    public void testCanTransact() {
        assertTrue(accounts.get("1").canTransact(now()));

    }

    /**
     * Experimente mit print().
     */
    @Test
    @Order(6)
    public void testPrint() {
        accounts.get("1").print();
    }

    /**
     * Experimente mit print(year,month).
     */
    @Test
    @Order(7)
    public void testMonthlyPrint() {
        accounts.get("1").print(2023, 5);
    }

}
