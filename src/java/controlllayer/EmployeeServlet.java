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
 * @author alexr
 */
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService();
    private DepartmentService departmentService = new DepartmentService();
    private DepartmentManagerService departmentManagerService = new DepartmentManagerService();
    private DepartmentEmployeeService departmentEmployeeService = new DepartmentEmployeeService();
    private TitleService titleService = new TitleService();
    private SalaryService salaryService = new SalaryService();

    private Employee employee;
    private List<Employee> employees;
    private Department department;
    private List<Department> departments;
    private String method = null;
    private int empNo = -1;
    private Date birthDate = null;
    private Date hireDate = null;
    private String firstName = "";
    private String lastName = "";
    private String gender = "";
    private String departmentNum = "";
    private Date deptFromDate = null;
    private Date deptToDate = null;
    private boolean isManager = false;
    private Date employeeTypeFrom = null;
    private Date employeeTypeTo = null;
    private String title = "";
    private Date titleFrom = null;
    private Date titleTo = null;
    private int salary = 0;
    private Date salaryFrom = null;
    private Date salaryTo = null;

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
        // Need to figure out based on the request coming in which method
        // needs to be invoked at the service level
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
//                case "search":
//                    search(request, response);
//                    break;
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
            employeeTypeFrom = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("managerFrom")).getTime());
            employeeTypeTo = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("managerTo")).getTime());
            titleFrom = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("titleFrom")).getTime());
            titleTo = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("titleTo")).getTime());
            salaryFrom = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("salaryFrom")).getTime());
            salaryTo = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("salaryTo")).getTime());
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        gender = request.getParameter("gender");

        departmentNum = request.getParameter("department");
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
            departmentSuccess = departmentEmployeeService.add(empNo, departmentNum, employeeTypeFrom, employeeTypeTo);
            titleSuccess = titleService.add(empNo, title, titleFrom, titleTo);
            salarySuccess = salaryService.add(empNo, salary, salaryFrom, salaryTo);
            if (isManager) {
                managerSuccess = departmentManagerService.add(empNo, departmentNum, employeeTypeFrom, employeeTypeTo);
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

//    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        employee = new Employee.Builder(empNo,
//                birthDate,
//                firstName,
//                lastName,
//                gender,
//                hireDate).build();
//        boolean success = employeeService.delete(employee);
//
//        if (success) {
//            view(request, response);
//        } else {
//            request.getRequestDispatcher("error.jsp").forward(request, response);
//        }
//
//        empNo = Integer.parseInt(request.getParameter("empNo"));
//        if (empNo > 0) {
//            employee = employeeService.getById(empNo);
//        }
//        request.setAttribute("employee", employee);
//        request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
