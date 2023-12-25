package com.lucas.springcubosapi.services;

import com.lucas.springcubosapi.dtos.ClientDTO;
import com.lucas.springcubosapi.entities.Client;
import com.lucas.springcubosapi.repositories.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    @DisplayName("Should save a client successfully")
    public void testSaveClientSuccess() {
        when(clientRepository.save(any())).thenReturn(client);

        Client clientSaved = clientService.save(clientDTO);

        ArgumentCaptor<Client> clientCaptor = ArgumentCaptor.forClass(Client.class);
        verify(clientRepository).save(clientCaptor.capture());

        Client capturedClient = clientCaptor.getValue();
        Assertions.assertEquals(capturedClient.getFirstName(), clientDTO.firstName());
        Assertions.assertEquals(capturedClient.getLastName(), clientDTO.lastName());
        Assertions.assertEquals(capturedClient.getParticipation(), clientDTO.participation());

        Assertions.assertEquals(clientSaved.getId(), client.getId());
        Assertions.assertEquals(clientSaved.getFirstName(), clientDTO.firstName());
        Assertions.assertEquals(clientSaved.getLastName(), clientDTO.lastName());
        Assertions.assertEquals(clientSaved.getParticipation(), clientDTO.participation());
    }
}