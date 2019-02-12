/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import dataaccesslayer.DepartmentDao;
import dataaccesslayer.DepartmentDaoImpl;
import datatransferobjects.Department;
import java.util.List;

/**
 * Services for Department to View, Add, GetByID.
 *
 * @author Robert Lange and Alexander Riccio
 */
public class DepartmentService {

    private DepartmentDao departmentDaoImpl = new DepartmentDaoImpl();

    /**
     * Get a list of Departments
     *
     * @return a list of Department employees
     */
    public List<Department> view() {
        return departmentDaoImpl.view();
    }

    /**
     * A count of the Departments table
     *
     * @return int value representing the count of the table
     */
    public int viewCount() {
        return departmentDaoImpl.viewCount();
    }

    /**
     * Getting Department by providing the primary key columns
     *
     * @param deptNo
     * @return
     */
    public Department getById(String deptNo) {
        return departmentDaoImpl.getById(deptNo);
    }

    /**
     * Adding a Department to the table
     *
     * @param deptName
     * @return
     */
    public String add(String deptName) {
        return departmentDaoImpl.add(deptName);
    }
}
