
package com.example.Server_deudas.controllers;

import com.example.Server_deudas.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Server_deudas.models.Client;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientController {
    @Autowired
    ClientService clientService;
    
    @GetMapping()
    public ArrayList<Client> get(){
        return this.clientService.getClients();
    }
    @GetMapping(path = "/{id}")
    public Optional<Client> getById(@PathVariable("id") Long id){
        return this.clientService.getClient(id);
    }
    @GetMapping(path = "/query")
    public Client getByCi(@RequestParam("ci") Long ci){
        return this.clientService.getClientByCi(ci);
    }
    @PostMapping()
    public Client post(@RequestBody Client client){
        return this.clientService.saveClient(client);
    }
    
    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable("id") Long id){
        if(this.clientService.deleteClient(id))
            return "Cliente Eliminado";
                    else
            return "Cliente no eleminado";
    }
}
