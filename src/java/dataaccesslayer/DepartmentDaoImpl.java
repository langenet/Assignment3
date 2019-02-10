/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexr
 */
public class DepartmentDaoImpl implements DepartmentDao {

    DataSource dataSource = DataSource.getInstance();

    public DepartmentDaoImpl() {

    }

    @Override
    public List<Department> view() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Department department = null;
        List<Department> departments = new ArrayList<>();

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select * from departments order by dept_no desc limit 20");

            rs = pstmt.executeQuery();
            String deptNo = "";
            String deptName = "";
            
            while (rs.next()) {
                deptNo = rs.getString("dept_no");
                deptName = rs.getString("dept_name");
                if (deptNo != null) {
                    department = new Department.Builder(deptNo, deptName).build();
                }
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            try {
                if (dataSource.getConnection() != null) {
                    dataSource.closeConnection();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return departments;
    }
}
