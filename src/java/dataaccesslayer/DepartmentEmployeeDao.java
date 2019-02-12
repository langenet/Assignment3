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
 *
 * @author alexr
 */
public interface DepartmentEmployeeDao {

    List<DepartmentEmployee> view();

    int viewCount();

    public boolean add(int empNo, String deptNo, Date fromDate, Date toDate);

    public DepartmentEmployee getById(int empNo, String deptNo);
}
