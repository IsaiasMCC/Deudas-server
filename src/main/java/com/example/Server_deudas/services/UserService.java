
package com.example.Server_deudas.services;

import com.example.Server_deudas.repositories.UserRepository;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.example.Server_deudas.models.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author isais
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public ArrayList<User> getUsers(){
        return (ArrayList<User>) this.userRepository.findAll();
    }
    public Optional<User> geUsertById(Long id){
        return this.userRepository.findById(id);
    }
    public User getUserByEmail(String email){
        return this.userRepository.findByEmail(email);
    }
    public User saveUser(User user){
        return this.userRepository.save(user);
    }
    public boolean deleteUser(Long id){
        try {
            this.userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
