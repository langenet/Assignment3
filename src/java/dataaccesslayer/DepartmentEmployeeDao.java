/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.DepartmentEmployee;
import java.util.Date;
import java.util.List;

/**
 * DAO Interface for Department Employee to View, Add, GetByID.
 *
 * @author Robert Lange and Alexander Riccio
 */
public interface DepartmentEmployeeDao {

    /**
     * Get a list of DepartmentEmployees
     *
     * @return a list of Department employees
     */
    List<DepartmentEmployee> view();

    /**
     * A count of the DepartmentEmployee table
     *
     * @return int value representing the count of the table
     */
    int viewCount();

    /**
     * Adding a DepartmentEmployee to the table
     *
     * @param empNo
     * @param deptNo
     * @param fromDate
     * @param toDate
     * @return
     */
    public boolean add(int empNo, String deptNo, Date fromDate, Date toDate);

    /**
     * Getting DepartmentEmployee by providing the primary key columns
     *
     * @param empNo
     * @param deptNo
     * @param fromDate
     * @return
     */
    public DepartmentEmployee getById(int empNo, String deptNo, Date fromDate);
}
