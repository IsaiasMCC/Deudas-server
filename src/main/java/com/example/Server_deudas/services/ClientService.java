
package com.example.Server_deudas.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Server_deudas.models.Client;
import com.example.Server_deudas.repositories.ClientRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
/**
 *
 * @author isais
 */
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    
    public ArrayList<Client> getClients(){
        return (ArrayList<Client>) this.clientRepository.findAll();
    }
    public Optional<Client> getClient(Long id){
        return this.clientRepository.findById(id);
    }
    public Client getClientByCi(Long ci){
        return this.clientRepository.findByCi(ci);
    }
    public Client saveClient(Client client){
        return this.clientRepository.save(client);
    }
    public boolean deleteClient(Long id){
        try {
            this.clientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
