/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.Employee;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robert
 */
public class EmployeeDaoImpl implements EmployeeDao {

    DataSource dataSource = DataSource.getInstance();

    public EmployeeDaoImpl() {
    }

    @Override
    public boolean add(Employee employee) {
//        Connection con = null;
        PreparedStatement pstmt = null;

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("Select max(emp_no) + 1 as emp_no from employees");
            ResultSet rs = pstmt.executeQuery();
            pstmt = con.prepareStatement("INSERT into employees (emp_no, birth_date, first_name, last_name, gender, hire_date) "
                    + " Values(?, ?, ?, ?, ?, ?)");
            if (rs.next()) {
                pstmt.setInt(1, rs.getInt("emp_no"));
                pstmt.setDate(2, new java.sql.Date(employee.getBirthDate().getTime()));
                pstmt.setString(3, employee.getFirstName());
                pstmt.setString(4, employee.getLastName());
                pstmt.setString(5, employee.getGender());
                pstmt.setDate(6, new java.sql.Date(employee.getHireDate().getTime()));
                pstmt.executeUpdate();
            } else {
                return false;
            }

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

    @Override
    public boolean update(Employee employee) {
//        Connection con = null;
        PreparedStatement pstmt = null;

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("update employees set birth_date = ?, first_name = ?, last_name = ?, gender = ?, hire_date = ? where emp_no = ?");
            pstmt.setDate(1, new java.sql.Date(employee.getBirthDate().getTime()));
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getLastName());
            pstmt.setString(4, employee.getGender());
            pstmt.setDate(5, new java.sql.Date(employee.getHireDate().getTime()));
            pstmt.setInt(6, employee.getEmpNo());
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

    @Override
    public List<Employee> view() {
//        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Employee employee = null;
        List<Employee> employees = new ArrayList<>();

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select * from employees order by emp_no desc limit 20");

            rs = pstmt.executeQuery();
            int empNo = -1;
            Date birthDate = null;
            String firstName = "";
            String lastName = "";
            String gender = "";
            Date hireDate = null;

            while (rs.next()) {
                empNo = rs.getInt("emp_no");
                birthDate = rs.getDate("birth_date");
                firstName = rs.getString("first_name");
                lastName = rs.getString("last_name");
                gender = rs.getString("gender");
                hireDate = rs.getDate("hire_date");
                if (empNo > 0) {
                    employee = new Employee.Builder(empNo,
                            birthDate,
                            firstName,
                            lastName,
                            gender,
                            hireDate,
                            department).build();
                }
                employees.add(employee);
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

        return employees;
    }

    @Override
    public Employee getById(int id) {
//        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Employee employee = null;

        try (Connection con = dataSource.createConnection()) {
            pstmt = con.prepareStatement("select * from employees where emp_No = ?");
            pstmt.setInt(1, id); // ToDo get the max employee number currently in the data base and set it + 1 here.

            rs = pstmt.executeQuery();
            int empNo = -1;
            Date birthDate = null;
            String firstName = "";
            String lastName = "";
            String gender = "";
            Date hireDate = null;

            while (rs.next()) {
                empNo = rs.getInt("emp_no");
                birthDate = rs.getDate("birth_date");
                firstName = rs.getString("first_name");
                lastName = rs.getString("last_name");
                gender = rs.getString("gender");
                hireDate = rs.getDate("hire_date");

            }
            if (empNo > 0) {
                employee = new Employee.Builder(id,
                        birthDate,
                        firstName,
                        lastName,
                        gender,
                        hireDate).build();
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

        return employee;
    }

    @Override
    public boolean delete(Employee employee) {
     //        Connection con = null;
        PreparedStatement pstmt = null;

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("delete from employees where emp_no = ?");
            pstmt.setInt(1, employee.getEmpNo());
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
