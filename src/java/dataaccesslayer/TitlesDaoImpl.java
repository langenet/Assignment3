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
    public void add(TitlesDaoImpl title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public TitlesDaoImpl getById(int empNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(EmployeeDaoImpl employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(EmployeeDaoImpl employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
