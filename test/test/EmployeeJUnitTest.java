/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import businesslayer.EmployeeService;
import datatransferobjects.Employee;
import java.util.Date;
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
    public void testingEmployeeAdd(){
        
        int empNo = -1;
        Date birthDate = new Date(2007, 1, 1);
        String firstName = "Joe";
        String lastName = "Smith";
        String gender = "m";
        Date hireDate = new Date(2018, 9, 9);
        
                
        Employee employee = new Employee.Builder(empNo,
                birthDate,
                firstName,
                lastName,
                gender,
                hireDate).build();
        
        EmployeeService employeeService = new EmployeeService();
        assertTrue(employeeService.add(employee) > 0);
    }
}
