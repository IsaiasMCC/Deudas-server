
package com.example.Server_deudas.models;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author isais
 */
@Entity
@Table(name = "Debt")
public class Debt {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    private String date_create;
    private String date_expiration;
    private Double total;
    private Long clientId;
    private boolean state;
    
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "client_id", referencedColumnName = "id")
//    private Client client;
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "debt")
//    private Collection<Payment> payments;
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "debt")
//    private Collection<DebtDetail> debt_details;
    //ManyToMany
    
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "Debt_Details",
//            joinColumns = @JoinColumn(name = "debt_id"),
//            inverseJoinColumns = @JoinColumn(name = "debt_concept_id")
//    )
//    private Collection<DebtConcept> debts_concept;
            
    public void setId(Long id){
        this.id = id;
    }
    public void setDateExpiration(String date_expiration){
        this.date_expiration = date_expiration;
    }
    public void setDateCreate(String date_create){
        this.date_create = date_create;
    }
    public void setTotal(Double total){
        this.total = total;
    }
    public void setClientId(Long clientId){
        this.clientId = clientId;
    }
    public void setState(boolean state){
        this.state = state;
    }
//    public void setClient(Client client){
//        this.client = client;
//    }

//    public void setDeptDetails( Collection<DebtDetail> debt_details){
//        this.debt_details = debt_details;
//    }
    public Long getId(){
        return this.id;
    }
       public Double getTotal(){
        return total;
    }
    public String getDateCreate(){
        return this.date_create;
    }
    public String getDateExpiration(){
        return this.date_expiration;
    }
    public Long getClientId(){
        return this.clientId;
    }
    public boolean getState(){
        return this.state;
    }
//    public Date getDateCreate(){
//        return this.date_create;
//    }
//    public Date getDateExpiration(){
//        return this.date_expiration;
//    }
 
//    public Client getClient(){
//        return this.client;
//    }

//    public Collection<DebtDetail> getDebtDetails(){
//        return this.debt_details;
//    } 

}
