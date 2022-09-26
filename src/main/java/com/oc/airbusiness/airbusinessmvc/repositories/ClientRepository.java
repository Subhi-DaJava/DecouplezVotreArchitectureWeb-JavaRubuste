package com.oc.airbusiness.airbusinessmvc.repositories;

import com.oc.airbusiness.airbusinessmvc.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
