package com.oc.airbusiness.airbusinessmvc.repositories;

import com.oc.airbusiness.airbusinessmvc.entities.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
