package com.oc.airbusiness.airbusinessmvc.repositories;

import com.oc.airbusiness.airbusinessmvc.entities.Plane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends CrudRepository<Plane, Long> {
}
