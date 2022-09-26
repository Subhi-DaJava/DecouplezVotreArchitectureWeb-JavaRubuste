package com.oc.airbusiness.airbusinessmvc.repositories;

import com.oc.airbusiness.airbusinessmvc.entities.MaintenanceIssue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends CrudRepository<MaintenanceIssue, Long> {
    // une chaîne vide pour trouver les éléments sans valeur pour la date de réparation
    List<MaintenanceIssue> findByFixed(String fixed);
}
