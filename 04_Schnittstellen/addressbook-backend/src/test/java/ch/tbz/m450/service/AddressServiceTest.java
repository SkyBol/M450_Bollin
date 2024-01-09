package ch.tbz.m450.service;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.repository.AddressRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddressServiceTest {

    @Mock
    private AddressRepository repository;

    @InjectMocks
    private AddressService service;

    private static final List<Address> addresses = new ArrayList<>();

    private static final List<Address> testAddresses = new ArrayList<>();

    @BeforeAll
    static void fillAddresses() {
        addresses.add(new Address(100, "Lea", "Marchol", "079 888 88 88", new Date()));
        addresses.add(new Address(101, "Paulo", "Hohler", "075 444 44 44", new Date()));
        addresses.add(new Address(102, "Hans", "Schmiedt", "079 555 55 55", new Date()));

        testAddresses.add(new Address(1, "Paulo", "Hohler", "075 444 44 44", new Date()));
        testAddresses.add(new Address(2, "Peter", "Hans", "079 555 55 55", new Date()));
        testAddresses.add(new Address(3, "Peter", "Hohler", "079 444 44 44", new Date()));
        testAddresses.add(new Address(4, "Peter", "Hohler", "079 333 33 33", new Date()));
    }

    @Test
    void save() {
        given(repository.save(any(Address.class))).willAnswer((invocation) -> addresses.get(0));

        var result = service.save(addresses.get(0));

        assertEquals(result.getId(), 100);
    }

    @Test
    void getAll() {
        given(repository.findAll()).willAnswer((invocation) -> addresses);

        var resultList = service.getAll();

        assertEquals(resultList.size(), 3);
    }

    @Test
    @DisplayName("Test Comparator Class for Addresses for Firstname Sorting")
    void testComparator_Firstname() {
        // Compare Firstname
        List<Address> testListFirstname = new ArrayList<>();
        testListFirstname.add(testAddresses.get(0));
        testListFirstname.add(testAddresses.get(1));

        given(repository.findAll()).willAnswer((invocation) -> testListFirstname);
        var resultList = service.getAll();
        assertEquals(resultList.size(), 2);
        assertEquals(resultList.get(0).getId(), 1); // Paulo > Peter
    }

    @Test
    @DisplayName("Test Comparator Class for Addresses for Lastname Sorting")
    void testComparator_Lastname() {
        // Compare Firstname
        List<Address> testListFirstname = new ArrayList<>();
        testListFirstname.add(testAddresses.get(1));
        testListFirstname.add(testAddresses.get(2));

        given(repository.findAll()).willAnswer((invocation) -> testListFirstname);
        var resultList = service.getAll();
        assertEquals(resultList.size(), 2);
        assertEquals(resultList.get(0).getId(), 2); // Hans > Hohler
    }

    @Test
    @DisplayName("Test Comparator Class for Addresses for Phone Numbers Sorting")
    void testComparator_PhoneNumber() {
        // Compare Firstname
        List<Address> testListFirstname = new ArrayList<>();
        testListFirstname.add(testAddresses.get(2));
        testListFirstname.add(testAddresses.get(3));

        given(repository.findAll()).willAnswer((invocation) -> testListFirstname);
        var resultList = service.getAll();
        assertEquals(resultList.size(), 2);
        assertEquals(resultList.get(0).getId(), 4); // 079 333 33 33 > 079 444 44 44
    }

    @Test
    void getAddress() {
        given(repository.findById(100)).willAnswer((invocation) -> Optional.of(addresses.get(0)));

        var result = service.getAddress(100);

        assertEquals(result.get().getId(), 100);
    }
}