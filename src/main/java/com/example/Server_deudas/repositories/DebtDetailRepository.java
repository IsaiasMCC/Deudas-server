
package com.example.Server_deudas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Server_deudas.models.DebtDetail;
import java.util.ArrayList;

/**
 *
 * @author isais
 */
@Repository
public interface DebtDetailRepository extends CrudRepository<DebtDetail, Long>{
    public abstract ArrayList<DebtDetail> findByDebtId(Long debtId);
}
