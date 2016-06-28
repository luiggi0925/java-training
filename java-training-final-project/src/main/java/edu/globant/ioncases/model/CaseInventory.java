/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author federico.calarco
 */

@Entity
public class CaseInventory implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Case caseCover;
    private int stock;

    public long getId() {
        return id;
    }

    public CaseInventory(Case caseCover, int stock) {
        this.caseCover = caseCover;
        this.stock = stock;
    }

    
    
    public void setId(long id) {
        this.id = id;
    }

    public Case getCaseCover() {
        return caseCover;
    }

    public void setCaseCover(Case caseCover) {
        this.caseCover = caseCover;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
}
