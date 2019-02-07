/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import dataaccesslayer.EmployeeDaoImpl;
import datatransferobjects.Employee;
import java.util.List;

/**
 *
 * @author alexr
 */
public class EmployeeService {
    private EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
    
    public void add(Employee employee){
        employeeDaoImpl.add(employee);
    }

    public List<Employee> view() {
        return employeeDaoImpl.view();
    }

    public Employee getById(int id) {
        return employeeDaoImpl.getById(id);
    }

    public void delete(Employee employee) {
        employeeDaoImpl.delete(employee);
    }

    public void edit(Employee employee) {
        employeeDaoImpl.edit(employee);
    }
}

