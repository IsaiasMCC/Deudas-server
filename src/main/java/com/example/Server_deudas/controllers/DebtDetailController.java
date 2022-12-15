
package com.example.Server_deudas.controllers;

import com.example.Server_deudas.services.DebtDetailService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Server_deudas.models.DebtDetail;
//import com.fasterxml.jackson.databind.util.JSONPObject;
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
@RequestMapping("/debtdetail")
@CrossOrigin("*")
public class DebtDetailController {
    @Autowired
    DebtDetailService debtDetailService;
    
    @GetMapping()
    public ArrayList<DebtDetail> getAll(){
        return this.debtDetailService.getDebtDetails();
    }
    @GetMapping(path = "/query")
    public ArrayList<DebtDetail> getAllByDebtId(@RequestParam("debt_id") Long debtId){
        return this.debtDetailService.getDebtDetailByDebtId(debtId);
    }
    @GetMapping(path = "/{id}")
    public Optional<DebtDetail> get(@PathVariable("id") Long id){
        return this.debtDetailService.getDebtDetail(id);
    }
    @PostMapping()
    public DebtDetail post(@RequestBody DebtDetail debDetail){
        return this.debtDetailService.saveDebtDetail(debDetail);
    }
    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable("id") Long id){
        if(this.debtDetailService.deleteDebtDetail(id))
           return "Detalle de Deuda Eliminado Correctamente";
        else 
          return  "Detalle de Deuda no Eliminado";
    }
}
