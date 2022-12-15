
package com.example.Server_deudas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.Server_deudas.models.Client;
import org.springframework.stereotype.Repository;
/**
 *
 * @author isais
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
    public abstract Client findByCi(Long ci);
}
