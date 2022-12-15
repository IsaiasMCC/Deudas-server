
package com.example.Server_deudas.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.Server_deudas.models.DebtConcept;
import com.example.Server_deudas.services.DebtConceptService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author isais
 */
@RestController
@RequestMapping("/debtconcept")
@CrossOrigin("*")
public class DebtConceptController {
    @Autowired
    DebtConceptService debtConceptService;
    
    @GetMapping()
    public ArrayList<DebtConcept> getAll(){
        return this.debtConceptService.getDebtConcepts();
    }
    @GetMapping("/{id}")
    public Optional<DebtConcept> get(@PathVariable("id") Long id){
        return this.debtConceptService.getDebtConcept(id);
    }
    @PostMapping()
    public DebtConcept post(@RequestBody DebtConcept debtConcept){
        return this.debtConceptService.saveDebtConcept(debtConcept);
    }
    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable("id") Long id){
        if(this.debtConceptService.deleteDebtConcept(id))
            return "Concept de Deuda Eliminado";
        else
            return "Concept de Deuda no Eliminado";
    }
}
