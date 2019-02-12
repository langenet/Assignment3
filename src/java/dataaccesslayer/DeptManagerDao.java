/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.DepartmentManager;
import java.util.Date;
import java.util.List;

/**
 * DAO Interface for Department Manager to View, Add, GetByID.
 *
 * @author Robert Lange and Alexander Riccio
 */
public interface DeptManagerDao {

    /**
     * Get a list of DepartmentManager
     *
     * @return a list of Department Managers
     */
    List<DepartmentManager> view();

    /**
     * A count of the DepartmentManager table
     *
     * @return int value representing the count of the table
     */
    int viewCount();

    /**
     * Adding a DepartmentManager to the table
     *
     * @param empNo
     * @param deptNo
     * @param fromDate
     * @param toDate
     * @return
     */
    public boolean add(int empNo, String deptNo, Date fromDate, Date toDate);

    /**
     * Getting DepartmentManager by providing the primary key columns
     *
     * @param empNo
     * @param deptNo
     * @return
     */
    public DepartmentManager getById(int empNo, String deptNo);
}
