package com.lucas.springcubosapi.services;

import com.lucas.springcubosapi.dtos.ClientDTO;
import com.lucas.springcubosapi.entities.Client;
import com.lucas.springcubosapi.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private Client client;
    private ClientDTO clientDTO;

    @BeforeEach
    public void setup() {
        client = new Client(UUID.randomUUID(), "John", "Doe", new BigDecimal(20.00));
        clientDTO = new ClientDTO("John", "Doe", new BigDecimal(20.00));

        MockitoAnnotations.initMocks(this);
    }
}