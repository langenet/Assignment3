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
    
    void addDptMgr(DeptManagerDaoImpl deptManager);
    List<EmployeeDaoImpl> view();
    EmployeeDaoImpl getById(DeptManagerDaoImpl deptManager);
    void delete(DeptManagerDaoImpl deptManager);
    void edit(DeptManagerDaoImpl deptManager);
    
}
