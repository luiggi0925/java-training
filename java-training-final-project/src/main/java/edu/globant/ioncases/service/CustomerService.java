/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.model.Customer;
import java.util.List;

/**
 *
 * @author fedec
 */
public interface CustomerService {

    void add(Customer customer);

    Customer getById(long id);

    List<Customer> getAll();
    
    void update(Customer customer);

    void remove(Customer customer);
}