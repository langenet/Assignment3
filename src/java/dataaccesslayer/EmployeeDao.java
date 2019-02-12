/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.Employee;
import java.util.List;

/**
 * DAO Interface for Employee to View, Add, GetByID, update, delete.
 *
 * @author Robert Lange and Alexander Riccio
 */
public interface EmployeeDao {

    /**
     * Adding a Employee to the table
     *
     * @param employee
     *
     * @return
     */
    int add(Employee employee);

    /**
     * update an Employee record
     *
     * @param employee
     * @return
     */
    boolean update(Employee employee);

    /**
     * Get a list of Employee
     *
     * @return a list of Department employees
     */
    List<Employee> view();

    /**
     * A count of the Employee table
     *
     * @return int value representing the count of the table
     */
    int viewCount();

    /**
     * Getting Employee by providing the primary key columns
     *
     * @param empNo
     * @return
     */
    Employee getById(int empNo);

    /**
     * Delete an Employee
     *
     * @param empNo
     * @return
     */
    boolean delete(int empNo);
}
