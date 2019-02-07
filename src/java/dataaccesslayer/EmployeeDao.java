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
   
    void add(EmployeeImpl employee);
    List<EmployeeImpl> view();
    EmployeeImpl getById  (int id);
    void delete(EmployeeImpl employee);
    void edit(EmployeeImpl employee);
    
    
    
    
}
