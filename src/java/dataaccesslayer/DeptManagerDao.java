/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import java.util.List;

/**
 *
 * @author Robert
 */
public interface DeptManagerDao {
    
    void addDptMgr(DeptManagerImpl deptManager);
    List<EmployeeImpl> view();
    EmployeeImpl getById(DeptManagerImpl deptManager);
    void delete(DeptManagerImpl deptManager);
    void edit(DeptManagerImpl deptManager);
    
}
