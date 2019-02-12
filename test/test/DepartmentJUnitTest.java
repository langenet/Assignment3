/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import businesslayer.DepartmentService;
import datatransferobjects.Department;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Robert Lange and Alexander Riccio
 */
public class DepartmentJUnitTest {

    public DepartmentJUnitTest() {
    }

    @Test
    public void testingDepartmentGetById() {

        String deptNo = "d009";
        String deptName = "Customer Service";

        DepartmentService departmentService = new DepartmentService();

        Department departmentValue = departmentService.getById(deptNo);
        assertTrue(departmentValue.getDeptName().equals(deptName));
    }

    @Test
    public void testingDepartmentAdd() {

        String deptName = "Helpdesk";

        DepartmentService departmentService = new DepartmentService();
        assertTrue(departmentService.add(deptName).length() > 0);
    }

    @Test
    public void testingDepartmentView() {

        String deptNo = "d009";
        String deptName = "Customer Service";

        Department lastDepartment = new Department.Builder(deptNo,
                deptName).build();
        
         deptNo = "d001";
        deptName = "Marketing";

        Department firstDepartment = new Department.Builder(deptNo,
                deptName).build();



        DepartmentService departmentService = new DepartmentService();

        List<Department> departments = departmentService.view();

        assertTrue(departments.size() == departmentService.viewCount());
        assertTrue(departments.contains(firstDepartment));
        assertTrue(departments.contains(lastDepartment));

    }
}
