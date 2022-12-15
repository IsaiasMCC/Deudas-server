
package com.example.Server_deudas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import java.util.Collection;

/**
 *
 * @author isais
 */
@Entity
@Table(name = "Debt_Concept")
public class DebtConcept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    private String description;
//    @OneToMany(mappedBy = "debt_concept")
//    private Collection<DebtDetail> debt_details;
    
//    @ManyToMany(mappedBy = "debts_concept")
//    private Collection<Debt> debts;
    
    public void setId(Long id){
        this.id = id; 
    }
    public void setDescription(String description){
        this.description = description;
    }
    
    public Long getId(){
        return this.id;
    }
    public String getDescription(){
        return this.description;
    }
}
