package com.oc.airbusiness.airbusinessmvc.repositories;

import com.oc.airbusiness.airbusinessmvc.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    // les clients qui ont des impayés
    @Query("SELECT c FROM Client c WHERE c.outstandingBalance > ?1")
    List<Client> findByOutstandingBalanceGreaterThan(double value);
}
