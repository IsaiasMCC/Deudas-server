
package com.example.Server_deudas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Server_deudas.models.Payment;
import java.util.ArrayList;
/**
 *
 * @author isais
 */
@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
    public abstract ArrayList<Payment>findByDebtId(Long debtId);
}
