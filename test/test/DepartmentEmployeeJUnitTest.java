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
public class DepartmentEmployeeJUnitTest implements RandomDateOfBirth {

    public DepartmentEmployeeJUnitTest() {
    }

    @Test
    public void testingDepartmentEmployeeGetById() {

        int empNo = 100001;
        String deptNo = "d005";
        Date fromDate = new GregorianCalendar(1999, 6, 17).getTime();
        Date toDate = new GregorianCalendar(2000, 5, 13).getTime();

        DepartmentEmployeeService departmentEmployeeService = new DepartmentEmployeeService();

        DepartmentEmployee departmentEmployeeValue = departmentEmployeeService.getById(empNo, deptNo, fromDate);
        assertTrue(departmentEmployeeValue.getFromDate().equals(fromDate));
        assertTrue(departmentEmployeeValue.getToDate().equals(toDate));
    }

    @Test
    public void testingDepartmentEmployeeAdd() {

        int year = RandomDateOfBirth.randBetween(1900, 1985);
        int month = RandomDateOfBirth.randBetween(0, 12);
        int day = RandomDateOfBirth.randBetween(0, 28);

        int empNo = 100001;
        String deptNo = "d004";
        Date fromDate = new GregorianCalendar(year, month, day).getTime();

        year = RandomDateOfBirth.randBetween(2000, 2019);
        month = RandomDateOfBirth.randBetween(0, 12);
        day = RandomDateOfBirth.randBetween(0, 28);

        Date toDate = new GregorianCalendar(year, month, day).getTime();

        DepartmentEmployeeService departmentEmployeeService = new DepartmentEmployeeService();
        // This is failing because the database doesn't use an ID column
        // Since we need to stick with this database design, we need to add
        // some logic to either verify if the entry is already in the table,
        // or try to randomize the emp_no and dept_no.  
        assertTrue(departmentEmployeeService.add(empNo, deptNo, fromDate, toDate));
    }

    @Test
    public void testingDepartmentEmployeeView() {

        int empNo = 100001;
        String deptNo = "d005";
        Date fromDate = new GregorianCalendar(1999, 6, 17).getTime();
        Date toDate = new GregorianCalendar(2000, 5, 13).getTime();

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
