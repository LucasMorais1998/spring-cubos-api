package com.lucas.springcubosapi.services;

import com.lucas.springcubosapi.dtos.ClientDTO;
import com.lucas.springcubosapi.entities.Client;
import com.lucas.springcubosapi.repositories.ClientRepository;
import com.lucas.springcubosapi.utils.ValidationUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(ClientDTO data) {
        ValidationUtils.ValidateClientData(data);

        Client newClient = new Client(data);

        return this.clientRepository.save(newClient);
    }

    public List<Client> listAll() {
        return this.clientRepository.findAll();
    }
}
