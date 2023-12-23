package com.lucas.springcubosapi.controllers;

import com.lucas.springcubosapi.dtos.ClientDTO;
import com.lucas.springcubosapi.entities.Client;
import com.lucas.springcubosapi.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody ClientDTO data) {

        Client newClient = this.clientService.save(data);

        return new ResponseEntity<>(newClient, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Client>> listAllClients() {
        List<Client> allClients = this.clientService.listAll();

        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }
}
