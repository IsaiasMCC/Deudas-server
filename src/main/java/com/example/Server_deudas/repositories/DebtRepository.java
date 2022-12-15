
package com.example.Server_deudas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.Server_deudas.models.Debt;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
/**
 *
 * @author isais
 */
@Repository
public interface DebtRepository extends CrudRepository<Debt, Long>{
    public abstract ArrayList<Debt> findByClientId(Long clientId);
}
