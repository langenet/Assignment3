/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import java.util.List;

/**
 *
 * @author Robert
 */
public interface EmployeeDao {
   
    void add(EmployeeDaoImpl employee);
    List<EmployeeDaoImpl> view();
    EmployeeDaoImpl getById  (int id);
    void delete(EmployeeDaoImpl employee);
    void edit(EmployeeDaoImpl employee);
    
    
    
    
}
