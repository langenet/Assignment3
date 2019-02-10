/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.Title;
import java.util.List;

/**
 *
 * @author Robert
 */
public interface TitlesDao {

    void add(TitlesDaoImpl title);
    List<Title> view();
    TitlesDaoImpl getById(int empNo);
    void delete(EmployeeDaoImpl employee);
    void edit(EmployeeDaoImpl employee);
    
    
}
