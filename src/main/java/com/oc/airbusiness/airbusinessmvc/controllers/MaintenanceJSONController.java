package com.oc.airbusiness.airbusinessmvc.controllers;

import com.oc.airbusiness.airbusinessmvc.entities.MaintenanceIssue;
import com.oc.airbusiness.airbusinessmvc.repositories.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ajouter une API à la partie maintenance de notre application.
 * Un excellent aspect de l’utilisation de notre framework existant.
 * Nous devons uniquement ajouter un contrôleur d’endpoint. Nous n’avons même pas besoin de générer une page HTML pour montrer les résultats !
 *
 */
@RestController
@RequestMapping(path = "v1/maintenance") // Le framework qu’il s’agit d’un contrôleur REST, et donnez-lui l’emplacement de l’endpoint.
public class MaintenanceJSONController {
    // Connecter le contrôleur au repository de maintenance.
    private final MaintenanceRepository maintenanceRepository;
    @Autowired
    public MaintenanceJSONController(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }
    //Ajouter le gestionnaire d’endpoint.
    @GetMapping(path = "/", produces = "application/json")
    public Iterable<MaintenanceIssue> maintenances(Model model) {
        return maintenanceRepository.findAll();
    }
    // localhost:8080/v1/maintenance/unfixed/
    @GetMapping(path="/unfixed", produces = "application/json")
    public Iterable<MaintenanceIssue> maintenanceForm( Model model) {
        return maintenanceRepository.findByFixed("");
    }
}
