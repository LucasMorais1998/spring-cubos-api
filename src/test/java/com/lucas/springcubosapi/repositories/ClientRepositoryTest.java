package com.lucas.springcubosapi.repositories;

import com.lucas.springcubosapi.entities.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@DataJpaTest
@ActiveProfiles("test")
class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;

    private Client client;

    @BeforeEach
    public void setClientConfiguration() {
        this.client = new Client(UUID.randomUUID(), "John", "Doe", new BigDecimal(20.00));
    }

    @Test
    @DisplayName("Should create a user successfully")
    public void testSaveUserSuccess() {
        Client saveClient = clientRepository.save(client);

        Assertions.assertNotNull(saveClient.getId());
        Assertions.assertEquals(client.getFirstName(), saveClient.getFirstName());
        Assertions.assertEquals(client.getLastName(), saveClient.getLastName());
        Assertions.assertEquals(client.getParticipation(), saveClient.getParticipation());
    }

    @Test
    @DisplayName("Should find all users successfully")
    public void testFindAllClientsSuccess() {
        Client saveClient = clientRepository.save(client);

        List<Client> allClients = clientRepository.findAll();

        Assertions.assertFalse(allClients.isEmpty());
        Assertions.assertTrue(allClients.contains(saveClient));
    }

}