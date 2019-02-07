/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Robert
 */
public class EmployeeDaoImpl implements EmployeeDao {

    
    public EmployeeDaoImpl(){      
    }

    @Override
    public void add(Employee employee) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            DataSource dataSource = new DataSource();
            con = dataSource.createConnection();
            pstmt = con.prepareStatement("INSERT into employee (emp_no, birth_date, first_name, last_name, gender, hire_date) " +
                                        " Values(?, ?, ?, ?, ?, ?");
            pstmt.setInt(1, 0); // ToDo get the max employee number currently in the data base and set it + 1 here.
            pstmt.setDate(2, employee.getBirthDate());
            pstmt.setString(3, employee.getFirstName());
            pstmt.setString(4, employee.getLastName());
            pstmt.setString(5, employee.getGender());
            pstmt.setDate(6, employee.getHireDate());
            pstmt.executeUpdate();
            
        } catch(SQLException e){
            e.printStackTrace();
	} finally {
            try {if(pstmt != null) { pstmt.close();}}
            catch(SQLException e) {System.err.println(e.getMessage());}
            try {if(con != null) { con.close();}}
            catch(SQLException e) {System.err.println(e.getMessage());}		
	    }  

    }

    @Override
    public List<Employee> view() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
