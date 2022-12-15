
package com.example.Server_deudas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Server_deudas.models.DebtDetail;
import com.example.Server_deudas.repositories.DebtDetailRepository;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author isais
 */

@Service
public class DebtDetailService {
    @Autowired
    DebtDetailRepository debtDetailRepository;
    
    public ArrayList<DebtDetail> getDebtDetails(){
        return (ArrayList<DebtDetail>) this.debtDetailRepository.findAll();
    }
    public Optional<DebtDetail> getDebtDetail(Long id){
        return debtDetailRepository.findById(id);
    }
    public ArrayList<DebtDetail> getDebtDetailByDebtId(Long debtId){
        return this.debtDetailRepository.findByDebtId(debtId);
    }
    public Double getTotalDebtDetail(Long debtId){
        Double total = 0.0;
        ArrayList<DebtDetail> array = this.debtDetailRepository.findByDebtId(debtId);
        for (DebtDetail debtDetail : array) {
            total = total + debtDetail.getAmount();
        }
        return total;
    }
    public DebtDetail saveDebtDetail(DebtDetail debtDetail){
        return this.debtDetailRepository.save(debtDetail);
    }
    public boolean deleteDebtDetail(Long id){
        try {
            this.debtDetailRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
