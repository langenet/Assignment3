/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.Employee;
import java.util.List;

/**
 *
 * @author Robert
 */
public interface EmployeeDao {

    boolean add(Employee employee);

    boolean update(Employee employee);

    List<Employee> view();

    Employee getById(int id);

    boolean delete(int empNo);

    void edit(Employee employee);

}
