/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import businesslayer.EmployeeService;
import datatransferobjects.Employee;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexr
 */
public class EmployeeJUnitTest {

    public EmployeeJUnitTest() {
    }

    @Test
    public void testingEmployeeAdd() {
        Date fromDate = new GregorianCalendar(1986, 5, 26).getTime();

        int empNo = -1;
        Date birthDate = new GregorianCalendar(2007, 1, 1).getTime();
        String firstName = "Joe";
        String lastName = "Smith";
        String gender = "m";
        Date hireDate = new GregorianCalendar(2018, 9, 9).getTime();

        Employee employee = new Employee.Builder(empNo,
                birthDate,
                firstName,
                lastName,
                gender,
                hireDate).build();

        EmployeeService employeeService = new EmployeeService();
        assertTrue(employeeService.add(employee) > 0);
    }

    @Test
    public void testingEmployeeView() {

        int empNo = 10001;
        Date birthDate = new GregorianCalendar(1953, 8, 2).getTime();
        String firstName = "Georgi";
        String lastName = "Facello";
        String gender = "M";
        Date hireDate = new GregorianCalendar(1986, 5, 26).getTime();

        Employee firstEmployee = new Employee.Builder(empNo,
                birthDate,
                firstName,
                lastName,
                gender,
                hireDate).build();

        empNo = 499999;
        birthDate = new GregorianCalendar(1958, 4, 1).getTime();
        firstName = "Sachin";
        lastName = "Tsukuda";
        gender = "M";
        hireDate = new GregorianCalendar(1997, 10, 30).getTime();

        Employee lastEmployee = new Employee.Builder(empNo,
                birthDate,
                firstName,
                lastName,
                gender,
                hireDate).build();

        EmployeeService employeeService = new EmployeeService();

        List<Employee> employees = employeeService.view();

        assertTrue(employees.size() == employeeService.viewCount());
        assertTrue(employees.contains(firstEmployee));
        assertTrue(employees.contains(lastEmployee));

    }
    
    @Test
    public void testEmployeeGetById(){
        int empNo = 10001;
        Date birthDate = new GregorianCalendar(1953, 8, 2).getTime();
        String firstName = "Georgi";
        String lastName = "Facello";
        String gender = "M";
        Date hireDate = new GregorianCalendar(1986, 5, 26).getTime();

        Employee expectedEmployee = new Employee.Builder(empNo,
                birthDate,
                firstName,
                lastName,
                gender,
                hireDate).build(); 
        
        
        EmployeeService employeeService = new EmployeeService();

        Employee actualEmployee = employeeService.getById(10001);
        
        assertTrue(expectedEmployee.equals(actualEmployee));
        
    }
}
