/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DAO Implementation for Employee to View, Add, GetByID, update, delete.
 *
 * @author Robert Lange and Alexander Riccio
 */
public class EmployeeDaoImpl implements EmployeeDao {

    private DataSource dataSource = DataSource.getInstance();

    public EmployeeDaoImpl() {
    }

    /**
     * Adding a Employee to the table
     *
     * @param employee
     *
     * @return
     */
    @Override
    public int add(Employee employee) {
        PreparedStatement pstmt = null;
        int empNo = -1;
        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("Select max(emp_no) + 1 as emp_no from employees");
            ResultSet rs = pstmt.executeQuery();
            pstmt = con.prepareStatement("INSERT into employees (emp_no, birth_date, first_name, last_name, gender, hire_date) "
                    + " Values(?, ?, ?, ?, ?, ?)");
            if (rs.next()) {
                empNo = rs.getInt("emp_no");
                pstmt.setInt(1, empNo);
                pstmt.setDate(2, new java.sql.Date(employee.getBirthDate().getTime()));
                pstmt.setString(3, employee.getFirstName());
                pstmt.setString(4, employee.getLastName());
                pstmt.setString(5, employee.getGender());
                pstmt.setDate(6, new java.sql.Date(employee.getHireDate().getTime()));
                pstmt.executeUpdate();
            } else {
                return empNo;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return empNo;
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

        return empNo;
    }

    /**
     * update an Employee record
     *
     * @param employee
     * @return
     */
    @Override
    public boolean update(Employee employee) {
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

    /**
     * Get a list of Employee
     *
     * @return a list of Department employees
     */
    @Override
    public List<Employee> view() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Employee employee = null;
        List<Employee> employees = new ArrayList<>();

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select emp_no, birth_date, first_name,"
                    + " last_name, gender, hire_date from employees order by emp_no desc");

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
                            hireDate).build();
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

    /**
     * A count of the Employee table
     *
     * @return int value representing the count of the table
     */
    @Override
    public int viewCount() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int viewCount = -1;

        try (Connection con = dataSource.createConnection()) {

            pstmt = con.prepareStatement("select count(*) count from employees");

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
     * Getting Employee by providing the primary key columns
     *
     * @param empNo
     * @return
     */
    @Override
    public Employee getById(int empNo) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Employee employee = null;

        try (Connection con = dataSource.createConnection()) {
            pstmt = con.prepareStatement("select * from employees where emp_No = ?");
            pstmt.setInt(1, empNo); // ToDo get the max employee number currently in the data base and set it + 1 here.

            rs = pstmt.executeQuery();
            int empNoValue = -1;
            Date birthDate = null;
            String firstName = "";
            String lastName = "";
            String gender = "";
            Date hireDate = null;

            while (rs.next()) {
                empNoValue = rs.getInt("emp_no");
                birthDate = rs.getDate("birth_date");
                firstName = rs.getString("first_name");
                lastName = rs.getString("last_name");
                gender = rs.getString("gender");
                hireDate = rs.getDate("hire_date");

            }
            if (empNo > 0) {
                employee = new Employee.Builder(empNoValue,
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

    /**
     * Delete an Employee
     *
     * @param employee
     * @return
     */
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
