package com.oc.airbusiness.airbusinessmvc.controllers;

import com.oc.airbusiness.airbusinessmvc.entities.Client;
import com.oc.airbusiness.airbusinessmvc.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/clients")
public class ClientJSONController {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientJSONController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @GetMapping(path = "/", produces = "application/json")
    public Iterable<Client> clients(Model model) {
        return clientRepository.findAll();
    }
    @GetMapping(path = "/client/{id}", produces = "application/json")
    public Client client(@PathVariable("id") long id) {
        return clientRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("This id does not exit " + id)
        );
    }
}
