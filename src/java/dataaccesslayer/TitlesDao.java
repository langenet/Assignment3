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

    void add(Titles title);
    List<Employee> view();
    Titles getById(int empNo);
    void delete(Employee employee);
    void edit(Employee employee);
    
    
}
