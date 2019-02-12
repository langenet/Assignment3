/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.Salary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DAO Implementation for Salary to View, Add, GetByID.
 *
 * @author Robert Lange and Alexander Riccio
 */
public class SalaryDaoImpl implements SalaryDao {

    DataSource dataSource = DataSource.getInstance();

    public SalaryDaoImpl() {
    }

    /**
     * Get a list of Salaries
     *
     * @return a list of Salaries
     */
    @Override
    public List<Salary> view() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Salary salary = null;
        List<Salary> salaries = new ArrayList<>();

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select emp_no, salary, from_date, to_date "
                    + "from salaries order by emp_no desc");

            rs = pstmt.executeQuery();
            int empNo = -1;
            int salaryValue = -1;
            Date fromDate = null;
            Date toDate = null;

            while (rs.next()) {
                empNo = rs.getInt("emp_no");
                salaryValue = rs.getInt("salary");
                fromDate = rs.getDate("from_date");
                toDate = rs.getDate("to_date");
                if (empNo > 0) {
                    salary = new Salary.Builder(empNo,
                            salaryValue,
                            fromDate,
                            toDate).build();
                }
                salaries.add(salary);
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

        return salaries;
    }

    /**
     * A count of the Salary table
     *
     * @return int value representing the count of the table
     */
    @Override
    public int viewCount() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int viewCount = -1;

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select count(*) count from salaries");

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

    /**
     * Getting Salary by providing the primary key columns
     *
     * @param empNo
     * @param fromDate
     * @return
     */
    @Override
    public Salary getById(int empNo, Date fromDate) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Salary salary = null;

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select * from salaries where "
                    + "emp_no = ? and from_date = ?");

            pstmt.setInt(1, empNo);
            pstmt.setDate(2, new java.sql.Date(fromDate.getTime()));

            rs = pstmt.executeQuery();
            int empNoValue = -1;
            int salaryValue = -1;
            Date fromDateValue = null;
            Date toDateValue = null;

            while (rs.next()) {
                empNoValue = rs.getInt("emp_no");
                salaryValue = rs.getInt("salary");
                fromDateValue = rs.getDate("from_date");
                toDateValue = rs.getDate("to_date");
                if (empNoValue > 0) {
                    salary = new Salary.Builder(empNoValue,
                            salaryValue,
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

        return salary;
    }

    /**
     * Adding a Salary to the table
     *
     * @param empNo
     * @param salary
     * @param fromDate
     * @param toDate
     * @return
     */
    public boolean add(int empNo, int salary, Date fromDate, Date toDate) {
        PreparedStatement pstmt = null;

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("INSERT into salaries (emp_No, salary, from_date, to_date) "
                    + " Values(?, ?, ?, ?)");
            pstmt.setInt(1, empNo);
            pstmt.setInt(2, salary);
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
