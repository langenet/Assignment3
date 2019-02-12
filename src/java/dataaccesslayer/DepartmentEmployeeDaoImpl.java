/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.DepartmentEmployee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alexr
 */
public class DepartmentEmployeeDaoImpl implements DepartmentEmployeeDao {

    DataSource dataSource = DataSource.getInstance();

    public DepartmentEmployeeDaoImpl() {
    }

    @Override
    public List<DepartmentEmployee> view() {
//        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DepartmentEmployee departmentEmployee = null;
        List<DepartmentEmployee> departmentEmployees = new ArrayList<>();

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select emp_no, dept_no, from_date, to_date"
                    + " from dept_emp order by emp_no desc");

            rs = pstmt.executeQuery();
            int empNo = -1;
            String deptNo = "";
            Date fromDate = null;
            Date toDate = null;

            while (rs.next()) {
                empNo = rs.getInt("emp_no");
                deptNo = rs.getString("dept_no");
                fromDate = rs.getDate("from_date");
                toDate = rs.getDate("to_date");
                if (empNo > 0) {
                    departmentEmployee = new DepartmentEmployee.Builder(empNo,
                            deptNo,
                            fromDate,
                            toDate).build();
                }
                departmentEmployees.add(departmentEmployee);
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

        return departmentEmployees;
    }

    @Override
    public int viewCount() {
//        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int viewCount = -1;

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select count(*) count from dept_emp");

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
    public DepartmentEmployee getById(int empNo, String deptNo, Date fromDate) {
//        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DepartmentEmployee departmentEmployee = null;
        List<DepartmentEmployee> departmentEmployees = new ArrayList<>();

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select * from dept_emp where emp_no = ?"
                    + " and dept_no = ? and from_date = ?");

            pstmt.setInt(1, empNo);
            pstmt.setString(2, deptNo);
            pstmt.setDate(3, new java.sql.Date(fromDate.getTime()));

            rs = pstmt.executeQuery();
            int empNoValue = -1;
            String deptNoValue = "";
            Date fromDateValue = null;
            Date toDateValue = null;

            while (rs.next()) {
                empNoValue = rs.getInt("emp_no");
                deptNoValue = rs.getString("dept_no");
                fromDateValue = rs.getDate("from_date");
                toDateValue = rs.getDate("to_date");
                if (empNoValue > 0) {
                    departmentEmployee = new DepartmentEmployee.Builder(empNoValue,
                            deptNoValue,
                            fromDateValue,
                            toDateValue).build();
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

        return departmentEmployee;
    }

    @Override
    public boolean add(int empNo, String deptNo, Date fromDate, Date toDate) {

        PreparedStatement pstmt = null;

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("INSERT into dept_emp (emp_no, dept_no, from_date, to_date) "
                    + " Values(?, ?, ?, ?)");
            pstmt.setInt(1, empNo);
            pstmt.setString(2, deptNo);
            pstmt.setDate(3, new java.sql.Date(fromDate.getTime()));
            pstmt.setDate(4, new java.sql.Date(toDate.getTime()));
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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

        return true;
    }
}
