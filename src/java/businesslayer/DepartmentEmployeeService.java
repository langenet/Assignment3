/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import dataaccesslayer.DepartmentEmployeeDao;
import dataaccesslayer.DepartmentEmployeeDaoImpl;
import dataaccesslayer.DeptManagerDaoImpl;
import datatransferobjects.DepartmentEmployee;
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

}
