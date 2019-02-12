/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import dataaccesslayer.DepartmentEmployeeDao;
import dataaccesslayer.DepartmentEmployeeDaoImpl;
import datatransferobjects.DepartmentEmployee;
import java.util.Date;
import java.util.List;

/**
 *  Services for Department Employee to View, Add, GetByID.
 * @author Robert Lange and Alexander Riccio
 */
public class DepartmentEmployeeService {

    private DepartmentEmployeeDao deptEmployeeImpl = new DepartmentEmployeeDaoImpl();

    /**
     * Get a list of DepartmentEmployees
     * @return a list of Department employees
     */
    public List<DepartmentEmployee> view() {
        return deptEmployeeImpl.view();
    }

    /**
     * A count of the DepartmentEmployee table
     * @return int value representing the count of the table
     */
    public int viewCount() {
        return deptEmployeeImpl.viewCount();
    }

    /**
     * Adding a DepartmentEmployee to the table
     * @param empNo
     * @param deptNo
     * @param fromDate
     * @param toDate
     * @return 
     */
    public boolean add(int empNo, String deptNo, Date fromDate, Date toDate) {
        return deptEmployeeImpl.add(empNo, deptNo, fromDate, toDate);
    }

    /**
     * Getting DepartmentEmployee by providing the primary key columns
     * @param empNo
     * @param deptNo
     * @param fromDate
     * @return 
     */
    public DepartmentEmployee getById(int empNo, String deptNo, Date fromDate) {
        return deptEmployeeImpl.getById(empNo, deptNo, fromDate);
    }

}
