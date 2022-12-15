
package com.example.Server_deudas.services;

import com.example.Server_deudas.repositories.DebtConceptRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Server_deudas.models.DebtConcept;
import java.util.ArrayList;
/**
 *
 * @author isais
 */
@Service
public class DebtConceptService {
    @Autowired
    DebtConceptRepository debtConceptRepository;
    
    public ArrayList<DebtConcept> getDebtConcepts(){
        return (ArrayList<DebtConcept>) this.debtConceptRepository.findAll();
    }
    public Optional<DebtConcept> getDebtConcept(Long id){
        return this.debtConceptRepository.findById(id);
    }
    public DebtConcept saveDebtConcept( DebtConcept debtConcept){
        return this.debtConceptRepository.save(debtConcept);
    }
    
    public boolean deleteDebtConcept(Long id){
        try {
            this.debtConceptRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
