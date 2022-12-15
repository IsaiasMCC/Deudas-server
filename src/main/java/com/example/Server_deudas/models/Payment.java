
package com.example.Server_deudas.models;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import java.util.Collection;
//import java.util.Date;

/**
 *
 * @author isais
 */
@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    private String description;
    private String direction;
    private String date;
    private Double amount;
    private Long debtId;
    
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "debt_id", referencedColumnName = "id")
//    private Debt debt;
    
    public void setId(Long id){
        this.id = id;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setDirection(String direction){
        this.direction = direction;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setAmount(Double amount){
        this.amount = amount;
    }
    public void setDebtId(Long debtId){
        this.debtId = debtId;
    }
    public Long getId(){
        return this.id;
    }
    public String getDescription(){
        return this.description;
    }
    public String getDirection(){
        return this.direction;
    }
    public String getDate(){
        return this.date;
    }
    public Double getAmount(){
        return this.amount;
    }
    public Long getDebtId(){
        return this.debtId;
    }
}
