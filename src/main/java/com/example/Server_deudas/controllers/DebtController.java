
package com.example.Server_deudas.controllers;

import com.example.Server_deudas.services.DebtService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Server_deudas.models.Debt;
import com.example.Server_deudas.models.DebtConcept;

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
@RequestMapping("/debt")
@CrossOrigin("*")
public class DebtController {
    @Autowired
    DebtService debtService;
    
    @GetMapping()
    public ArrayList<Debt> getAll(){
        return this.debtService.getDebts();
    }
    @GetMapping(path = "/{id}")
    public Optional<Debt> get(@PathVariable("id") Long id){
        return this.debtService.getDebt(id);
    }
    @GetMapping(path = "/query")
    public ArrayList<Debt> getAllByClientId(@RequestParam("client_id") Long client_id){
        return this.debtService.getDebtByClientId2(client_id);
    }
    @GetMapping(path = "/concepts/query")
    public ArrayList<Optional<DebtConcept>> getAllConceptsByClientId(@RequestParam("debt_id") Long id){
        return this.debtService.getDebtConcetpByDebtId(id);
    }
    @PostMapping()
    public Debt post(@RequestBody Debt debt){
        return this.debtService.saveDebt(debt);
    }
    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable("id") Long id){
        if(this.debtService.deleteDebt(id))
            return "Deuda Eliminada";
        else
            return "Deuda no Eliminada";
    }
}
