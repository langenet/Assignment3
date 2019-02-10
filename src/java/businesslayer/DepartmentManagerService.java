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
 *
 * @author alexr
 */
public class DepartmentManagerService {

    private DeptManagerDao deptManagerDaoImpl = new DeptManagerDaoImpl();

    public List<DepartmentManager> view() {
        return deptManagerDaoImpl.view();
    }

    public boolean add(int empNo, String deptNo, Date fromDate, Date toDate) {
        return deptManagerDaoImpl.add(empNo, deptNo, fromDate, toDate);
    }

}
