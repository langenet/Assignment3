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
public interface TitlesDao {

    void add(TitlesImpl title);
    List<EmployeeImpl> view();
    TitlesImpl getById(int empNo);
    void delete(EmployeeImpl employee);
    void edit(EmployeeImpl employee);
    
    
}
