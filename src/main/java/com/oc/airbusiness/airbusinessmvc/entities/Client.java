package com.oc.airbusiness.airbusinessmvc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * Le modèle contient l’état de l’application.
 * Le modèle est composé d’entités.
 * Le stockage d’informations du modèle doit être abstrait du reste.
 * Extrayez le modèle en introduisant des couches de modèle et de persistance.
 * Utilisez un framework MVC pour vous simplifier le travail.
 */
@Entity // Added Data Storage Annotation
public class Client {
    @Id // Added id for the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generate id
    private long id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    private String address;
    private String telephone;
    private double outstandingBalance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(double outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }
}
