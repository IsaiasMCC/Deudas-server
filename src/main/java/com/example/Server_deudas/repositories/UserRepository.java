
package com.example.Server_deudas.repositories;

import org.springframework.stereotype.Repository;
import com.example.Server_deudas.models.User;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author isais
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    public abstract User findByEmail(String email);
}
