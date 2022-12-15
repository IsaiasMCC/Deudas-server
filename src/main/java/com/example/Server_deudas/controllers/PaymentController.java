
package com.example.Server_deudas.controllers;

import com.example.Server_deudas.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Server_deudas.models.Payment;
import java.util.ArrayList;
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
@RequestMapping("/payment")
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    
    @GetMapping()
    public ArrayList<Payment> getAll(){
        return this.paymentService.getPayments();
    }
    @GetMapping(path = "/{id}")
    public Optional<Payment> get(@PathVariable("id") Long id){
        return this.paymentService.getPayment(id);
    }
    @GetMapping(path = "/query")
    public ArrayList<Payment> getByDebtId(@RequestParam("debt_id") Long debtId){
        return this.paymentService.getPaymentsByDebtId(debtId);
    }
    @GetMapping(path = "/payments/query")
    public ArrayList<Payment> getAllByClientId(@RequestParam("client_id") Long clientId){
        return this.paymentService.getPaymentsByClientId(clientId);
    }
    @PostMapping()
    public Payment post(@RequestBody Payment payment){
        return this.paymentService.savePayment(payment);
    }
    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable("id") Long id){
        if(this.paymentService.deletePayment(id))
            return "Payment eliminado correctamente";
        else
            return "Payment no eliminado";
    }
    
}
