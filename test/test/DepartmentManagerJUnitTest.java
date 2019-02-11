/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import businesslayer.DepartmentManagerService;
import datatransferobjects.DepartmentManager;
import java.util.Date;
import java.util.GregorianCalendar;
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
}
