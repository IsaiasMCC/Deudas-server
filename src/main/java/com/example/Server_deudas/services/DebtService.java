package com.example.Server_deudas.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Server_deudas.models.Debt;
import com.example.Server_deudas.repositories.DebtRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.Server_deudas.models.DebtConcept;
import com.example.Server_deudas.models.DebtDetail;
/**
 *
 * @author isais
 */
@Service
public class DebtService {
    @Autowired
    DebtRepository debtRepository;
    @Autowired
    DebtDetailService debtDetailService;
    @Autowired
    DebtConceptService debtConceptService;
    
    public ArrayList<Debt> getDebts(){
        return (ArrayList<Debt>) this.debtRepository.findAll();
    }
    public ArrayList<Debt> getDebsByClientId(Long clientId){
        return this.debtRepository.findByClientId(clientId);
    }
    public ArrayList<Debt> getDebtByClientId2(Long clientId){
        ArrayList<Debt> array = this.debtRepository.findByClientId(clientId);
        ArrayList<Debt> newArray = new ArrayList();
        for (Debt debt : array) {
            if(!debt.getState()){
            Double totalItem = this.debtDetailService.getTotalDebtDetail(debt.getId());
            debt.setTotal(totalItem);
            newArray.add( this.debtRepository.save(debt));
            }
        }
        return newArray;
    }
    
    public ArrayList<Optional<DebtConcept>> getDebtConcetpByDebtId(Long id){
        ArrayList<Optional<DebtConcept>> conceptos = new ArrayList();
            ArrayList<DebtDetail> detalles = this.debtDetailService.getDebtDetailByDebtId(id);
            for(DebtDetail debtDetail : detalles){
                Optional<DebtConcept> concept = this.debtConceptService.getDebtConcept(debtDetail.getDebtConceptId());
                conceptos.add(concept);
            }
        return conceptos;
    }
    public Optional<Debt> getDebt(Long id){
        return this.debtRepository.findById(id);
    }
    public Debt saveDebt(Debt debt){
        return this.debtRepository.save(debt);
    }
    public boolean deleteDebt(Long id){
        try {
            this.debtRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
