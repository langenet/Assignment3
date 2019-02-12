/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import dataaccesslayer.DeptManagerDao;
import dataaccesslayer.DeptManagerDaoImpl;
import datatransferobjects.DepartmentManager;
import java.util.Date;
import java.util.List;

/**
 * Services for Department Manager to View, Add, GetByID.
 *
 * @author Robert Lange and Alexander Riccio
 */
public class DepartmentManagerService {

    private DeptManagerDao deptManagerDaoImpl = new DeptManagerDaoImpl();

    /**
     * Get a list of DepartmentManager
     *
     * @return a list of Department Managers
     */
    public List<DepartmentManager> view() {
        return deptManagerDaoImpl.view();
    }

    /**
     * A count of the DepartmentManager table
     *
     * @return int value representing the count of the table
     */
    public int viewCount() {
        return deptManagerDaoImpl.viewCount();
    }

    /**
     * Adding a DepartmentManager to the table
     *
     * @param empNo
     * @param deptNo
     * @param fromDate
     * @param toDate
     * @return
     */
    public boolean add(int empNo, String deptNo, Date fromDate, Date toDate) {
        return deptManagerDaoImpl.add(empNo, deptNo, fromDate, toDate);
    }

    /**
     * Getting DepartmentManager by providing the primary key columns
     *
     * @param empNo
     * @param deptNo
     * @return
     */
    public DepartmentManager getById(int empNo, String deptNo) {
        return deptManagerDaoImpl.getById(empNo, deptNo);
    }

}
