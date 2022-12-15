
package com.example.Server_deudas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import java.util.ArrayList;
//import java.util.Collection;

/**
 *
 * @author isais
 */
@Entity
@Table(name = "Client")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    private Long ci;
    @Column(unique = true, nullable = false)
    
    private String name;
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
//    private Collection<Debt> debts;
    
    public void setId(Long id){
        this.id = id;
    }
    public void setCi(Long ci){
        this.ci = ci;
    }
    public void setName(String name){
        this.name = name;
    }
//    public void setDebts(Collection<Debt> debts){
//        this.debts = debts;
//    }
    public Long getId(){
        return id;
    }
    public Long getCi(){
        return ci;
    }
    public String getName(){
        return name;
    }
//    public Collection<Debt> getDets(){
//        return this.debts;
//    }
}
