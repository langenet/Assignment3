/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlllayer;

import businesslayer.DepartmentManagerService;
import businesslayer.DepartmentService;
import businesslayer.EmployeeService;
import datatransferobjects.Department;
import datatransferobjects.DepartmentManager;
import datatransferobjects.Employee;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexr
 */
public class DepartmentManagerServlet extends HttpServlet {

    EmployeeService employeeService = new EmployeeService();
    Employee employee;
    List<Employee> employees;

    DepartmentService departmentService = new DepartmentService();
    Department department;
    List<Department> departments;

    DepartmentManagerService departmentManagerService = new DepartmentManagerService();
    DepartmentManager departmentManager;
    List<DepartmentManager> departmentManagers;

    String method = null;
    int empNo = -1;

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
//        method = request.getParameter("method");
//        if (method != null) {
            view(request, response);
   //     }
    }

    private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        departmentManagers = departmentManagerService.view();
        request.setAttribute("departmentManagers", departmentManagers);
        request.getRequestDispatcher("departmentManager.jsp").forward(request, response);
    }
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
        processRequest(request, response);
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
