/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import businesslayer.DepartmentEmployeeService;
import datatransferobjects.DepartmentEmployee;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexr
 */
public class DepartmentEmployeeJUnitTest {

    public DepartmentEmployeeJUnitTest() {
    }

    @Test
    public void testingDepartmentEmployeeGetById() {

        int empNo = 10001;
        String deptNo = "d005";
        Date fromDate = new GregorianCalendar(1986, 5, 26).getTime();
        Date toDate = new GregorianCalendar(9999, 0, 1).getTime();

        DepartmentEmployeeService departmentEmployeeService = new DepartmentEmployeeService();

        DepartmentEmployee departmentEmployeeValue = departmentEmployeeService.getById(empNo, deptNo);
        assertTrue(departmentEmployeeValue.getFromDate().equals(fromDate));
        assertTrue(departmentEmployeeValue.getToDate().equals(toDate));
    }

    @Test
    public void testingDepartmentEmployeeAdd() {

        int empNo = 10001;
        String deptNo = "d004";
        Date fromDate = new GregorianCalendar(1996, 8, 2).getTime();
        Date toDate = new GregorianCalendar(2006, 4, 25).getTime();
        
        DepartmentEmployeeService departmentEmployeeService = new DepartmentEmployeeService();
        assertTrue(departmentEmployeeService.add(empNo, deptNo, fromDate, toDate));
    }

    @Test
    public void testingDepartmentEmployeeView() {

        int empNo = 10001;
        String deptNo = "d005";
        Date fromDate = new GregorianCalendar(1986, 5, 26).getTime();
        Date toDate = new GregorianCalendar(9999, 0, 1).getTime();

        DepartmentEmployee firstDepartmentEmployee = new DepartmentEmployee.Builder(empNo,
                deptNo,
                fromDate,
                toDate).build();

        empNo = 499999;
        deptNo = "d004";
        fromDate = new GregorianCalendar(1997, 10, 30).getTime();
        toDate = new GregorianCalendar(9999, 0, 1).getTime();

        DepartmentEmployee lastDepartmentEmployee = new DepartmentEmployee.Builder(empNo,
                deptNo,
                fromDate,
                toDate).build();

        DepartmentEmployeeService departmentEmployeeService = new DepartmentEmployeeService();

        List<DepartmentEmployee> departmentEmployees = departmentEmployeeService.view();

        assertTrue(departmentEmployees.size() == departmentEmployeeService.viewCount());
        assertTrue(departmentEmployees.contains(firstDepartmentEmployee));
        assertTrue(departmentEmployees.contains(lastDepartmentEmployee));

    }
}
