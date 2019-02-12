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
 * Services for Employee to View, Add, GetByID, update, delete.
 *
 * @author Robert Lange and Alexander Riccio
 */
public class EmployeeService {

    private EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();

    /**
     * Adding a Employee to the table
     *
     * @param employee
     *
     * @return
     */
    public int add(Employee employee) {
        return employeeDaoImpl.add(employee);
    }

    /**
     * update an Employee record
     *
     * @param employee
     * @return
     */
    public boolean update(Employee employee) {
        return employeeDaoImpl.update(employee);
    }

    /**
     * Get a list of Employee
     *
     * @return a list of Department employees
     */
    public List<Employee> view() {
        return employeeDaoImpl.view();
    }

    /**
     * A count of the Employee table
     *
     * @return int value representing the count of the table
     */
    public int viewCount() {
        return employeeDaoImpl.viewCount();
    }

    /**
     * Getting Employee by providing the primary key columns
     *
     * @param empNo
     * @return
     */
    public Employee getById(int empNo) {
        return employeeDaoImpl.getById(empNo);
    }

    /**
     * Delete an Employee
     *
     * @param employee
     * @return
     */
    public boolean delete(int empNo) {
        return employeeDaoImpl.delete(empNo);
    }
}
