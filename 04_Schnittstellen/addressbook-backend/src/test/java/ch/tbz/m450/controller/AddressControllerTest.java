package ch.tbz.m450.controller;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.service.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AddressController.class)
class AddressControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AddressService service;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final List<Address> addresses = new ArrayList<>();

    @BeforeAll
    static void fillAddresses() {
        addresses.add(new Address(100, "Lea", "Marchol", "079 888 88 88", new Date()));
        addresses.add(new Address(101, "Paulo", "Hohler", "075 444 44 44", new Date()));
        addresses.add(new Address(102, "Hans", "Schmiedt", "079 555 55 55", new Date()));
    }

    @Test
    void createAddress() throws Exception {
        Address address = new Address(1, "Test", "Tester", "075 411 41 41", new Date());

        given(service.save(any(Address.class))).willAnswer((invocation) -> invocation.getArgument(0));

        mockMvc.perform(
                post("/address")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(objectMapper.writeValueAsString(address))
            ).andExpect(status().isCreated());
    }

    @Test
    void getAddresses() throws Exception {
        given(service.getAll()).willAnswer((invocation) -> addresses);

        mockMvc.perform(get("/address")).andExpect(status().isOk());
    }

    @Test
    void getAddress() throws Exception {
        given(service.getAddress(1000)).willAnswer((invocation) -> Optional.of(addresses.get(0)));

        mockMvc.perform(get("/address/1000")).andExpect(status().isOk());
    }
}