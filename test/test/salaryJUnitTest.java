/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import businesslayer.SalaryService;
import datatransferobjects.Salary;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexr
 */
public class salaryJUnitTest {

    public salaryJUnitTest() {
    }

    @Test
    public void testingSalaryGetById() {

        int empNo = 10001;
        int salary = 60117;
        Date fromDate = new GregorianCalendar(1986, 5, 26).getTime();
        Date toDate = new GregorianCalendar(1987, 5, 26).getTime();

        SalaryService salaryService = new SalaryService();

        Salary salaryValue = salaryService.getById(empNo, fromDate);
        assertTrue(salaryValue.getSalary() == salary);
        assertTrue(salaryValue.getToDate().equals(toDate));
    }
}
