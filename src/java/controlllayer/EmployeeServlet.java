/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlllayer;

import businesslayer.EmployeeService;
import datatransferobjects.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexr
 */
public class EmployeeServlet extends HttpServlet {

    EmployeeService employeeService = new EmployeeService();
    
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
        
        
//        Example:
        
        int empNo = -1;
        Date birthDate = null, hireDate = null;
        String firstName = "", lastName = "", gender = "";
 
        switch(request.getParameter("method")){
        case "add":
            
            empNo = Integer.parseInt(request.getParameter("empNo"));
            try{
                
            birthDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthDate")).getTime());
            hireDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hireDate")).getTime());
            }catch(ParseException parseException){
                parseException.printStackTrace();
            }
            
            firstName = request.getParameter("firstName");
            lastName = request.getParameter("lastName");
            gender = request.getParameter("gender");
            
            
            
            if(empNo > 0 ){
                employee = new Employee.Builder(empNo, 
                                                    birthDate, 
                                                    firstName, 
                                                    lastName, 
                                                    gender, 
                                                    hireDate).build();
            }
            
            boolean success = employeeService.add(employee);
           
            if(success){
                // display success page
            }else{
                //display error
            }
            
        
        
        ;
//            .... fill in all the fields this way then...
            
//            employeeService.add(employee);
        case "view":
//            employeeService.view();
        case "getById":
            
            
            empNo = Integer.parseInt(request.getParameter("empNo"));
//            try{
                
//            birthDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthDate")).getTime());
//            hireDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hireDate")).getTime());
//            }catch(ParseException parseException){
//                parseException.printStackTrace();
//            }
            
//            firstName = request.getParameter("firstName");
//            lastName = request.getParameter("lastName");
//            gender = request.getParameter("gender");
//            
            
            
            if(empNo > 0 ){
                
                employee = employeeService.getById(empNo);
//                employee = new Employee.Builder(empNo, 
//                                                    birthDate, 
//                                                    firstName, 
//                                                    lastName, 
//                                                    gender, 
//                                                    hireDate).build();
            }
            request.setAttribute("employee",employee);
            request.getRequestDispatcher("viewEmployee.jsp").forward(request, response);
        }
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

