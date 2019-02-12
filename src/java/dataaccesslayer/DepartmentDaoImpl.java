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

            pstmt = con.prepareStatement("select dept_no, dept_name "
                    + "from departments order by dept_no desc");

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

    @Override
    public int viewCount() {
//        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int viewCount = -1;

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select count(*) count from departments");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                viewCount = rs.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return viewCount;
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
        return viewCount;
    }

    @Override
    public Department getById(String deptNo) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Department department = null;

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select * from departments where dept_no = ?");

            pstmt.setString(1, deptNo);
            rs = pstmt.executeQuery();
            String deptNoValue = "";
            String deptNameValue = "";

            while (rs.next()) {
                deptNoValue = rs.getString("dept_no");
                deptNameValue = rs.getString("dept_name");
                if (deptNoValue != null) {
                    department = new Department.Builder(deptNoValue, deptNameValue).build();
                }
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

        return department;
    }

    @Override
    public String add(String deptName) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String newDeptNo = "";

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("Select max(dept_no) dept_no from departments");
            rs = pstmt.executeQuery();
            pstmt = con.prepareStatement("INSERT into departments (dept_no, dept_name) "
                    + " Values(?, ?)");
            if (rs.next()) {
                int nextDeptNo = Integer.parseInt(rs.getString("dept_no").substring(1, 4));
                nextDeptNo++;
                int length = (int) (Math.log10(nextDeptNo) + 1);
                switch (length) {
                    case 1:
                        newDeptNo = "d00" + Integer.toString(nextDeptNo);
                        break;
                    case 2:
                        newDeptNo = "d0" + Integer.toString(nextDeptNo);
                        break;
                    case 3:
                        newDeptNo = "d" + Integer.toString(nextDeptNo);
                        break;
                    default:
                        newDeptNo = "";
                }
                pstmt.setString(1, newDeptNo);
                pstmt.setString(2, deptName);
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return newDeptNo;
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

        return newDeptNo;
    }
}
