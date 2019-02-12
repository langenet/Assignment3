/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlllayer;

import businesslayer.DepartmentEmployeeService;
import businesslayer.DepartmentManagerService;
import businesslayer.DepartmentService;
import businesslayer.EmployeeService;
import businesslayer.SalaryService;
import businesslayer.TitleService;
import datatransferobjects.Department;
import datatransferobjects.Employee;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Robert Lange and Alexander Riccio
 */
public class EmployeeServlet extends HttpServlet {

    private final EmployeeService employeeService = new EmployeeService();
    private final DepartmentService departmentService = new DepartmentService();
    private final DepartmentManagerService departmentManagerService = new DepartmentManagerService();
    private final DepartmentEmployeeService departmentEmployeeService = new DepartmentEmployeeService();
    private final TitleService titleService = new TitleService();
    private final SalaryService salaryService = new SalaryService();

    private Employee employee;
    private List<Employee> employees;
    private List<Department> departments;
    private String method = null;
    private int empNo = -1;
    private Date birthDate = null;
    private Date hireDate = null;
    private String firstName = "";
    private String lastName = "";
    private String gender = "";
    private String deptNo = "";
    private Date deptFromDate = null;
    private Date deptToDate = null;
    private boolean isManager = false;
    private Date managerFromDate = null;
    private Date managerToDate = null;
    private String title = "";
    private Date titleFromDate = null;
    private Date titleToDate = null;
    private int salary = 0;
    private Date salaryFromDate = null;
    private Date salaryToDate = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Employee employee = null;
        method = request.getParameter("method");
        if (method != null) {

            switch (method) {
                case "add":
                    add(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
                case "view": // might be able to remove this one
                    view(request, response);
                    break;
                case "getById":
                    getById(request, response);
                    break;
                case "edit":
                    edit(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "initAdd":
                    initAdd(request, response);
                    break;
                default:
                    view(request, response);
                    break;
            }
        } else {
            view(request, response);
        }
    }

    private void initAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        departments = departmentService.view();
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            birthDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthDate")).getTime());
            hireDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hireDate")).getTime());
            deptFromDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("deptFromDate")).getTime());
            deptToDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("deptToDate")).getTime());
            managerFromDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("managerFrom")).getTime());
            managerToDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("managerTo")).getTime());
            titleFromDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("titleFrom")).getTime());
            titleToDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("titleTo")).getTime());
            salaryFromDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("salaryFrom")).getTime());
            salaryToDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("salaryTo")).getTime());
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        gender = request.getParameter("gender");

        deptNo = request.getParameter("department");
        isManager = Boolean.parseBoolean(request.getParameter("isManager"));
        title = request.getParameter("title");
        salary = Integer.parseInt(request.getParameter("salary"));

        employee = new Employee.Builder(empNo,
                birthDate,
                firstName,
                lastName,
                gender,
                hireDate).build();

        boolean employeeSuccess = false;
        boolean departmentSuccess = false;
        boolean managerSuccess = false;
        boolean titleSuccess = false;
        boolean salarySuccess = false;

        empNo = employeeService.add(employee);
        if (empNo > 0) {
            employeeSuccess = true;
            departmentSuccess = departmentEmployeeService.add(empNo, deptNo, deptFromDate, deptToDate);
            titleSuccess = titleService.add(empNo, title, titleFromDate, titleToDate);
            salarySuccess = salaryService.add(empNo, salary, salaryFromDate, salaryToDate);
            if (isManager) {
                managerSuccess = departmentManagerService.add(empNo, deptNo, managerFromDate, managerToDate);
            } else {
                managerSuccess = true;
            }

        }

        if (employeeSuccess
                && departmentSuccess
                && titleSuccess
                && salarySuccess
                && managerSuccess) {
            view(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            birthDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthDate")).getTime());
            hireDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hireDate")).getTime());
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        gender = request.getParameter("gender");

        empNo = Integer.parseInt(request.getParameter("empNo"));

        employee = new Employee.Builder(empNo,
                birthDate,
                firstName,
                lastName,
                gender,
                hireDate).build();

        if (employeeService.update(employee)) {
            view(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        employees = employeeService.view();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        empNo = Integer.parseInt(request.getParameter("empNo"));
        if (empNo > 0) {

            employee = employeeService.getById(empNo);
        }
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("viewEmployee.jsp").forward(request, response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        empNo = Integer.parseInt(request.getParameter("empNo"));
        if (empNo > 0) {
            employee = employeeService.getById(empNo);
        }
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        employee = new Employee.Builder(empNo,
                birthDate,
                firstName,
                lastName,
                gender,
                hireDate).build();

        boolean success = employeeService.delete(employee);

        if (success) {
            view(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        empNo = Integer.parseInt(request.getParameter("empNo"));
        if (empNo > 0) {
            employee = employeeService.getById(empNo);
        }
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
    }
}