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
 *
 * @author alexr
 */
public class DepartmentEmployeeService {

    private DepartmentEmployeeDao deptEmployeeImpl = new DepartmentEmployeeDaoImpl();

    public List<DepartmentEmployee> view() {
        return deptEmployeeImpl.view();
    }

    public int viewCount() {
        return deptEmployeeImpl.viewCount();
    }

    public boolean add(int empNo, String deptNo, Date fromDate, Date toDate) {
        return deptEmployeeImpl.add(empNo, deptNo, fromDate, toDate);
    }

    public DepartmentEmployee getById(int empNo, String deptNo) {
        return deptEmployeeImpl.getById(empNo, deptNo);
    }

}
