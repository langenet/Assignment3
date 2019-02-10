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
 *
 * @author alexr
 */
public class SalaryDaoImpl implements SalaryDao {
     DataSource dataSource = DataSource.getInstance();
     
    public SalaryDaoImpl() {
    }

    @Override
    public List<Salary> view() {
//        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Salary salary = null;
        List<Salary> salaries = new ArrayList<>();

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select * from salaries order by emp_no desc limit 20");

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
}
