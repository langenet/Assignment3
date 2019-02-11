/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.Title;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Robert
 */
public class TitlesDaoImpl implements TitlesDao {

    DataSource dataSource = DataSource.getInstance();

    public TitlesDaoImpl() {
    }

    @Override
    public List<Title> view() {
//        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Title title = null;
        List<Title> titles = new ArrayList<>();

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select * from titles order by emp_no desc limit 20");

            rs = pstmt.executeQuery();
            int empNo = -1;
            String titleValue = "";
            Date fromDate = null;
            Date toDate = null;

            while (rs.next()) {
                empNo = rs.getInt("emp_no");
                titleValue = rs.getString("title");
                fromDate = rs.getDate("from_date");
                toDate = rs.getDate("to_date");
                if (empNo > 0) {
                    title = new Title.Builder(empNo,
                            titleValue,
                            fromDate,
                            toDate).build();
                }
                titles.add(title);
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

        return titles;
    }

    @Override
    public boolean add(int empNo, String title, Date fromDate, Date toDate) {
        PreparedStatement pstmt = null;

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("INSERT into titles (emp_no, title, from_date, to_date) "
                    + " Values(?, ?, ?, ?)");
            pstmt.setInt(1, empNo);
            pstmt.setString(2, title);
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

    public Title getById(int empNo, String searchTitle, Date fromDate) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Title title = null;

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select * from titles where emp_no = ?"
                    + " and title = ?"
                    + " and from_date = ?");

            pstmt.setInt(1, empNo);
            pstmt.setString(2, searchTitle);
            pstmt.setDate(3, new java.sql.Date(fromDate.getTime()));

            rs = pstmt.executeQuery();
            int empNoValue = -1;
            String titleValue = "";
            Date fromDateValue = null;
            Date toDateValue = null;

            while (rs.next()) {
                empNoValue = rs.getInt("emp_no");
                titleValue = rs.getString("title");
                fromDateValue = rs.getDate("from_date");
                toDateValue = rs.getDate("to_date");
                if (empNoValue > 0) {
                    title = new Title.Builder(empNoValue,
                            titleValue,
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

        return title;
    }

}
