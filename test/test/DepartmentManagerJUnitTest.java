/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import businesslayer.DepartmentEmployeeService;
import businesslayer.DepartmentManagerService;
import datatransferobjects.DepartmentEmployee;
import datatransferobjects.DepartmentManager;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexr
 */
public class DepartmentManagerJUnitTest {

    public DepartmentManagerJUnitTest() {
    }

    @Test
    public void testingDepartmentManagerGetById() {

        int empNo = 110022;
        String deptNo = "d001";
        Date fromDate = new GregorianCalendar(1985, 0, 1).getTime();
        Date toDate = new GregorianCalendar(1991, 9, 1).getTime();

        DepartmentManagerService departmentManagerService = new DepartmentManagerService();

        DepartmentManager departmentManagerValue = departmentManagerService.getById(empNo, deptNo);
        assertTrue(departmentManagerValue.getFromDate().equals(fromDate));
        assertTrue(departmentManagerValue.getToDate().equals(toDate));
    }

    @Test
    public void testingDepartmentManagerAdd() {

        int empNo = 100001;
        String deptNo = "d004";
        Date fromDate = new GregorianCalendar(1996, 8, 2).getTime();
        Date toDate = new GregorianCalendar(2006, 4, 25).getTime();

        // This is failing because the database doesn't use an ID column
        // Since we need to stick with this database design, we need to add
        // some logic to either verify if the entry is already in the table,
        // or try to randomize the emp_no and dept_no.  
        DepartmentEmployeeService departmentEmployeeService = new DepartmentEmployeeService();
        assertTrue(departmentEmployeeService.add(empNo, deptNo, fromDate, toDate));
    }

    @Test
    public void testingDepartmentManagerView() {

        int empNo = 110022;
        String deptNo = "d001";
        Date fromDate = new GregorianCalendar(1985, 0, 1).getTime();
        Date toDate = new GregorianCalendar(1991, 9, 1).getTime();

        DepartmentManager firstDepartmentManager = new DepartmentManager.Builder(empNo,
                deptNo,
                fromDate,
                toDate).build();

        empNo = 111939;
        deptNo = "d009";
        fromDate = new GregorianCalendar(1996, 0, 3).getTime();
        toDate = new GregorianCalendar(9999, 0, 1).getTime();

        DepartmentManager lastDepartmentManager = new DepartmentManager.Builder(empNo,
                deptNo,
                fromDate,
                toDate).build();

        DepartmentManagerService departmentManagerService = new DepartmentManagerService();

        List<DepartmentManager> departmentManagers = departmentManagerService.view();

        assertTrue(departmentManagers.size() == departmentManagerService.viewCount());
        assertTrue(departmentManagers.contains(firstDepartmentManager));
        assertTrue(departmentManagers.contains(lastDepartmentManager));

    }
}
