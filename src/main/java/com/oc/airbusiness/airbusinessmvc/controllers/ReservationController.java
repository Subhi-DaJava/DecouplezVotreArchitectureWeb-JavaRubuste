package com.oc.airbusiness.airbusinessmvc.controllers;

import com.oc.airbusiness.airbusinessmvc.entities.Reservation;
import com.oc.airbusiness.airbusinessmvc.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ReservationController {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    @GetMapping("/new-trip")
    public String showNewTripForm(Reservation user) {
        return "reservation/add-reservation";
    }
    @PostMapping("/reservation/add")
    public String addReservation(
            @Valid Reservation reservation
            ,BindingResult result
            , Model model) {
        if(result.hasErrors()) {
            return "reservation/add-reservation";
        }
        reservationRepository.save(reservation);
        model.addAttribute("reservation", reservationRepository.findAll());
        return "reservation/reservations";
    }
    @GetMapping("reservation/edit/{id}")
    public String showUpdateReservationForm(@PathVariable("id") long id, Model model) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid reservation id: " + id));
        model.addAttribute("reservation", reservation);
        return "reservation/update-reservation";
    }
    @PostMapping("/reservation/update/{id}")
    public String updateReservation(
            @PathVariable("id") long id,
            @Valid Reservation reservation, BindingResult result, Model model) {
        if(result.hasErrors()) {
            reservation.setId(id);
            return "reservation/update-reservation";
        }

        reservationRepository.save(reservation);
        model.addAttribute("reservations", reservationRepository.findAll());
        return "reservation/reservations";
    }
    @GetMapping("/reservation/delete/{id}")
    public String deleteReservation(@PathVariable("id") long id,
                                    Model model) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid reservation id: " + id));
        reservationRepository.deleteById(id);
        model.addAttribute("reservations", reservationRepository.findAll());
        return "reservation/reservations";
    }
    @RequestMapping("/reservations")
    public String reservationsForm(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        return "reservation/reservations";
    }

}
