
package com.example.Server_deudas.models;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author isais
 */
@Entity
@Table(name = "Debt_Detail")
public class DebtDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    private Double amount;
    private Long debtId;
    private Long debtConceptId;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "debt_id")
//    private Debt debt;
    
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "debt_concept_id")
//    private DebtConcept debt_concept;
    
    public void setDebtDetail(Long id){
        this.id = id;
    }
    public void setAmount( Double amount){
        this.amount = amount;
    }
    public void setDebtId(Long debtId){
        this.debtId = debtId;
    }
    public void setDebtConceptId(Long debtConceptId){
        this.debtConceptId = debtConceptId;
    }
    public Long getId(){
        return this.id;
    }
    public Double getAmount(){
        return this.amount;
    }
    public Long getDebtId(){
        return this.debtId;
    }
    public Long getDebtConceptId(){
        return this.debtConceptId;
    }
}
