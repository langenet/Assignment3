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
 *
 * @author Robert
 */
public interface DeptManagerDao {

    List<DepartmentManager> view();

    public boolean add(int empNo, String deptNo, Date fromDate, Date toDate);

    public DepartmentManager getById(int empNo, String deptNo);
}
