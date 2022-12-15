
package com.example.Server_deudas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Server_deudas.models.DebtConcept;
/**
 *
 * @author isais
 */
@Repository
public interface DebtConceptRepository extends CrudRepository<DebtConcept, Long>{

}
