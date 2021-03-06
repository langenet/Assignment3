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
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Robert Lange and Alexander Riccio
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

    @Test
    public void testingSalaryAdd() {

        int year = RandomDateOfBirth.randBetween(1900, 1985);
        int month = RandomDateOfBirth.randBetween(0, 12);
        int day = RandomDateOfBirth.randBetween(0, 28);

        int empNo = 10001;
        int salary = 60117;
        Date fromDate = new GregorianCalendar(year, month, day).getTime();

        year = RandomDateOfBirth.randBetween(1900, 1985);
        month = RandomDateOfBirth.randBetween(0, 12);
        day = RandomDateOfBirth.randBetween(0, 28);
        
        Date toDate = new GregorianCalendar(year, month, day).getTime();

        SalaryService salaryService = new SalaryService();
        assertTrue(salaryService.add(empNo, salary, fromDate, toDate));
    }

    @Test
    public void testingSalaryView() {

        int empNo = 10001;
        int salary = 60117;
        Date fromDate = new GregorianCalendar(1947, 9, 8).getTime();
        Date toDate = new GregorianCalendar(1929, 1, 24).getTime();

        Salary firstSalary = new Salary.Builder(empNo,
                salary,
                fromDate,
                toDate).build();

        empNo = 499999;
        salary = 77303;
        fromDate = new GregorianCalendar(2001, 10, 29).getTime();
        toDate = new GregorianCalendar(9999, 0, 1).getTime();

        Salary lastSalary = new Salary.Builder(empNo,
                salary,
                fromDate,
                toDate).build();

        SalaryService salaryService = new SalaryService();

        List<Salary> salaries = salaryService.view();

        assertTrue(salaries.size() == salaryService.viewCount());
        assertTrue(salaries.contains(firstSalary));
        assertTrue(salaries.contains(lastSalary));

    }
}
