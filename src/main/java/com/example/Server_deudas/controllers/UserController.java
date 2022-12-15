
package com.example.Server_deudas.controllers;

import com.example.Server_deudas.services.UserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Server_deudas.models.User;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author isais
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    
    @GetMapping()
    public ArrayList<User> getAll(){
        return this.userService.getUsers();
    }
    @GetMapping(path = "/{id}")
    public Optional<User> getById(@PathVariable("id") Long id){
        return this.userService.geUsertById(id);
    }
    @GetMapping(path = "/query")
    public User getByEmail(@RequestParam("email") String email){
        return this.userService.getUserByEmail(email);
    }
    
    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable("id") Long id){
        if(this.userService.deleteUser(id))
            return "User delete exitosamente";
        else
            return "User no eliminado";
    }
    @PostMapping()
    public User post(@RequestBody User user){
        return userService.saveUser(user);
    }
    
    
    
}
