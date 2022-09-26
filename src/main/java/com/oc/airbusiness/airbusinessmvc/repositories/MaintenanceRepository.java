package com.oc.airbusiness.airbusinessmvc.repositories;

import com.oc.airbusiness.airbusinessmvc.entities.MaintenanceIssue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends CrudRepository<MaintenanceIssue, Long> {
}
