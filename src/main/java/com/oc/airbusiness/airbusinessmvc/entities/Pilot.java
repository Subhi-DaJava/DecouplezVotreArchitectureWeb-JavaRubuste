package com.oc.airbusiness.airbusinessmvc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Pilot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    private String address;
    private String telephone;
    private String aircraftRating; // Class de l'avion
    private String arrivalAirport; // Aéroport d'arrivée
    private String departureAirport; // Aéroport de départ

    public Pilot() {
    }

    public Pilot(String firstName, String lastName, String address, String telephone, String aircraftRating, String arrivalAirport, String departureAirport, LocalDate licencesExpiration, String licenceNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephone = telephone;
        this.aircraftRating = aircraftRating;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
        this.licencesExpiration = licencesExpiration;
        this.licenceNumber = licenceNumber;
    }

    private LocalDate licencesExpiration; // Date d'expiration du permis de vol
    private String licenceNumber; // Numéro du permis de vol


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

    public String getAircraftRating() {
        return aircraftRating;
    }

    public void setAircraftRating(String aircraftRating) {
        this.aircraftRating = aircraftRating;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public LocalDate getLicencesExpiration() {
        return licencesExpiration;
    }

    public void setLicencesExpiration(LocalDate licencesExpiration) {
        this.licencesExpiration = licencesExpiration;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
