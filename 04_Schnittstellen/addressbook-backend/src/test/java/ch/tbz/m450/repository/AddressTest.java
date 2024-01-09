package ch.tbz.m450.repository;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressTest {
    private static final List<Address> addresses = new ArrayList<>();

    @BeforeAll
    static void fillAddresses() {
        addresses.add(new Address(100, "Lea", "Marchol", "079 888 88 88", new Date()));
        addresses.add(new Address(101, "Paulo", "Hohler", "075 444 44 44", new Date()));
        addresses.add(new Address(102, "Hans", "Schmiedt", "079 555 55 55", new Date()));
    }

    @Test
    @Order(1)
    void getId() {
        assertEquals(addresses.get(0).getId(), 100);
    }

    @Test
    @Order(2)
    void getFirstname() {
        assertEquals(addresses.get(0).getFirstname(), "Lea");
    }

    @Test
    @Order(3)
    void getLastname() {
        assertEquals(addresses.get(0).getLastname(), "Marchol");
    }

    @Test
    @Order(4)
    void getPhonenumber() {
        assertEquals(addresses.get(0).getPhonenumber(), "079 888 88 88");
    }

    @Test
    @Order(5)
    void setId() {
        addresses.get(0).setId(999);
        assertEquals(addresses.get(0).getId(), 999);
    }

    @Test
    @Order(6)
    void setFirstname() {
        addresses.get(0).setFirstname("Test");
        assertEquals(addresses.get(0).getFirstname(), "Test");
    }

    @Test
    @Order(7)
    void setLastname() {
        addresses.get(0).setLastname("Tester");
        assertEquals(addresses.get(0).getLastname(), "Tester");
    }

    @Test
    @Order(8)
    void setPhonenumber() {
        addresses.get(0).setPhonenumber("404");
        assertEquals(addresses.get(0).getPhonenumber(), "404");
    }
}