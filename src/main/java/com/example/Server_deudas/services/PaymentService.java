
package com.example.Server_deudas.services;

import com.example.Server_deudas.models.Payment;
import com.example.Server_deudas.repositories.DebtRepository;
import com.example.Server_deudas.repositories.PaymentRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Server_deudas.models.Debt;
/**
 *
 * @author isais
 */

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    DebtRepository debtRepository;
    
    public ArrayList<Payment> getPayments(){
        return (ArrayList<Payment>) this.paymentRepository.findAll();
    }
    public ArrayList<Payment> getPaymentsByDebtId(Long debtId){
        return this.paymentRepository.findByDebtId(debtId);
    }
    public Optional<Payment> getPayment(Long id){
        return this.paymentRepository.findById(id);
    }
    public Payment savePayment(Payment payment){
        Optional<Debt> debt = this.debtRepository.findById(payment.getDebtId());
            debt.get().setState(true);
            this.debtRepository.save(debt.get());
        return  this.paymentRepository.save(payment);
    }
    public ArrayList<Payment> getPaymentsByClientId(Long clientId){
        ArrayList<Debt> deudas = this.debtRepository.findByClientId(clientId);
        ArrayList<Payment> newArray = new ArrayList();
        for (Debt debt : deudas) {
            if(debt.getState()){
                ArrayList<Payment> pagos = this.paymentRepository.findByDebtId(debt.getId());
                for(Payment pay: pagos){
                    newArray.add(pay);
                }
            }
        }
        return newArray;
    }
    public boolean deletePayment(Long id){
        try {
            this.paymentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}