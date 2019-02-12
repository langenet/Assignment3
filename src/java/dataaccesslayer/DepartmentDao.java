/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.Department;
import java.util.List;

/**
 * DAO Interface for Department to View, Add, GetByID.
 *
 * @author Robert Lange and Alexander Riccio
 */
public interface DepartmentDao {

    /**
     * Get a list of Departments
     *
     * @return a list of Department employees
     */
    List<Department> view();

    /**
     * A count of the Departments table
     *
     * @return int value representing the count of the table
     */
    int viewCount();

    /**
     * Getting Department by providing the primary key columns
     *
     * @param deptNo
     * @return
     */
    Department getById(String deptNo);

    /**
     * Adding a Department to the table
     *
     * @param deptNo
     * @return
     */
    String add(String deptNo);

}
