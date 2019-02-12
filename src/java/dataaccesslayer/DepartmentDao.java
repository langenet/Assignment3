/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.Department;
import java.util.List;

/**
 *
 * @author alexr
 */
public interface DepartmentDao {

    List<Department> view();

    int viewCount();

    Department getById(String deptNo);

    String add(String deptName);

}
