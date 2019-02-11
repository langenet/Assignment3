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
}
