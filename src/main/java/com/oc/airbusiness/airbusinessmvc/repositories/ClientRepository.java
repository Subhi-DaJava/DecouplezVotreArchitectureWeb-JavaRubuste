package com.oc.airbusiness.airbusinessmvc.repositories;

import com.oc.airbusiness.airbusinessmvc.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Le framework Spring Boot : ajouter une annotation (@Entity) sur les classes de Modèles,
 * et de paramétrer des getters et setters. Lorsqu’un objet est nécessaire, le framework le crée, puis appelle les setters appropriés pour initialiser l’objet.
 * Lorsque l’objet est modifié, les getters sont appelés et les valeurs sont stockées.
 *
 * Les opérations de bases de données CRUD standard : create (créer), read (lire), update (mettre à jour) et delete (supprimer).
 *
 * Une API désigne la communication entre deux modules, quels qu’ils soient.
 * Dans le cas d’une application monolithique, nous n’avons pas de modules définis, donc notre application se parle intégralement à elle-même, et de façon désordonnée.
 *
 * Explorer les avantages de l’utilisation d’une API pour gérer une architecture web découplée
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    // les clients qui ont des impayés
    @Query("SELECT c FROM Client c WHERE c.outstandingBalance > ?1")
    List<Client> findByOutstandingBalanceGreaterThan(double value);
}
