package com.oc.airbusiness.airbusinessmvc.controllers;

import com.oc.airbusiness.airbusinessmvc.entities.Client;
import com.oc.airbusiness.airbusinessmvc.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Le contrôleur lie les couches de vue, de modèle, et de données les unes aux autres.
 */
@Controller
public class ClientController {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @GetMapping("/new-client")
    public String showNewClientForm(Client client) {
        return "client/add-client";
    }

    @PostMapping("/client/add")
    public String addClient(@Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "client/add-client";
        }

        clientRepository.save(client);
        model.addAttribute("clients", clientRepository.findAll());
        return "client/clients";
    }

    @GetMapping("/client/edit/{id}")
    public String showUpdateClientForm(@PathVariable("id") long id, Model model) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        return "client/update-client";
    }

    @PostMapping("/client/update/{id}")
    public String updateClient(@PathVariable("id") long id, @Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            client.setId(id);
            return "client/update-client";
        }

        clientRepository.save(client);
        model.addAttribute("clients", clientRepository.findAll());
        return "client/clients";
    }

    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable("id") long id, Model model) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        clientRepository.delete(client);
        model.addAttribute("clients", clientRepository.findAll());
        return "client/clients";
    }

    @RequestMapping("/clients")
    public String clientsForm( Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        return "client/clients";
    }

    @RequestMapping("/clients/owe")
    public String clientsOwe(Model model) {
        model.addAttribute("clients", clientRepository.findByOutstandingBalanceGreaterThan(0.0));
        return "client/clients";
    }
}
