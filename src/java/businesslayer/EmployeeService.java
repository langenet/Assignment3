/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import dataaccesslayer.EmployeeDao;
import dataaccesslayer.EmployeeDaoImpl;
import datatransferobjects.Employee;
import java.util.List;

/**
 *
 * @author alexr
 */
public class EmployeeService {

    private EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();

    public int add(Employee employee) {
        return employeeDaoImpl.add(employee);
    }

    public boolean update(Employee employee) {
        return employeeDaoImpl.update(employee);
    }

    public List<Employee> view() {
        return employeeDaoImpl.view();
    }

    public Employee getById(int id) {
        return employeeDaoImpl.getById(id);
    }

    public boolean delete(Employee employee) {
        return employeeDaoImpl.delete(employee);
    }
}
