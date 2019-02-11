/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlllayer;

import businesslayer.DepartmentService;
import datatransferobjects.Department;
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
public class DepartmentServlet extends HttpServlet {

    DepartmentService departmentService = new DepartmentService();
    Department department;
    List<Department> departments;
    String method = null;
    String deptNo = "";
    String deptName = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        method = request.getParameter("method");

        if (method != null) {

            switch (method) {
                case "add":
//                case "update":
//                    add(request, response);
//                    break;
                case "view": // might be able to remove this one
                    view(request, response);
                    break;
//                case "delete":
//                    delete(request, response);
//                    break;
                default:
                    view(request, response);
                    break;
            }
        } else {
            view(request, response);
        }
    }

    private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        departments = departmentService.view();

        request.setAttribute("departments", departments);
        request.getRequestDispatcher("department.jsp").forward(request, response);
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
