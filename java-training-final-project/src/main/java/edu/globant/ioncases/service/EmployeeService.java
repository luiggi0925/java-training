/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.entity.Employee;

/**
 *
 * @author fedec
 */
public interface EmployeeService {
    
    void addEmployee(Employee employee);

    Employee getEmployee(Employee employee);

    Employee getEmployee(int id);
    
}
