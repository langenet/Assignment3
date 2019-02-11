/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import businesslayer.DepartmentService;
import datatransferobjects.Department;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexr
 */
public class DepartmentJUnitTest {

    public DepartmentJUnitTest() {
    }

    @Test
    public void testingDepartmentEmployeeGetById() {

        String deptNo = "d009";
        String deptName = "Customer Service";

        DepartmentService departmentService = new DepartmentService();

        Department departmentValue = departmentService.getById(deptNo);
        assertTrue(departmentValue.getDeptName().equals(deptName));
    }
}
