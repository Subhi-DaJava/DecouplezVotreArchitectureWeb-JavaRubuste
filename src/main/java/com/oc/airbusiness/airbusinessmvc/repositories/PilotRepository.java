package com.oc.airbusiness.airbusinessmvc.repositories;

import com.oc.airbusiness.airbusinessmvc.entities.Pilot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotRepository extends CrudRepository<Pilot, Long> {
}
