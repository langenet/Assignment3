/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import dataaccesslayer.DepartmentDaoImpl;
import datatransferobjects.Department;
import java.util.List;

/**
 *
 * @author alexr
 */
public class DepartmentService {
    
    private DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();;

    public List<Department> view() {
        return departmentDaoImpl.view();
    }
}
