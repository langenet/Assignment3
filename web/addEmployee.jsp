<%-- 
    Document   : addEmployee
    Created on : 8-Feb-2019, 9:30:28 AM
    Author     : Robert Lange and Alexander Riccio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employee</title>
    </head>

    <body>
        <%@ include file="header.jsp" %>  

    <center>
        <h1>Add Employee</h1>

        <form action ="EmployeeServlet" method ="POST">
            <input type="hidden" value="add" name="method" />
            <hr/>
            <table border="0" cellpadding="5" width="300">
                <tr>
                    <td>
                        First Name: 
                    </td>
                    <td>
                        <input type="text" name="firstName" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Last Name: 
                    </td>
                    <td>
                        <input type="text" name="lastName" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Birth Date: 
                    </td>
                    <td>
                        <input type="text" name="birthDate" id="birthDate" required 
                               pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$" title="yyyy-mm-dd" />                             
                    </td>
                </tr>
                <tr>
                    <td>
                        Gender: 
                    </td>
                    <td>
                        <select name="gender">

                            <option value="M">Male</option>
                            <option value="F">Female</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Hire Date: 
                    </td>
                    <td>
                        <input type="text" name="hireDate" required 
                               pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$" title="yyyy-mm-dd" />
                    </td>
                </tr>
            </table>
            <hr/>
            <table border="0">
                <tr>
                    <td>
                        Department:
                    </td>
                    <td>
                        <select  name="department">
                            <c:forEach items="${departments}" var="departmentValue">
                                <option value="${departmentValue.deptNo}">${departmentValue.deptName}</option>
                            </c:forEach>
                        </select>                       
                    </td>
                </tr>
                <tr>
                    <td>
                        From:
                    </td>
                    <td>
                        <input type="text" name="deptFromDate" required
                               pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$" title="yyyy-mm-dd" />                   
                    </td>
                </tr>
                <tr>
                    <td>
                        To:
                    </td>
                    <td>
                        <input type="text" name="deptToDate" required
                               pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$" title="yyyy-mm-dd" />                   

                    </td>
                </tr>
            </table>
            <hr/>
            <table border="0">
                <tr>
                    <td>
                        Employee Type:
                    </td>
                    <td>
                        <input type="checkbox" name="isManager" value="true">Manager?<br/>

                    </td>
                </tr>
                <tr>
                    <td>
                        From:
                    </td>
                    <td>
                        <input type="text" name="managerFrom" required
                               pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$" title="yyyy-mm-dd" />                   
                    </td>
                </tr>
                <tr>
                    <td>
                        To:
                    </td>
                    <td>
                        <input type="text" name="managerTo" required
                               pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$" title="yyyy-mm-dd" />                   

                    </td>
                </tr>
            </table>
            <hr/>
            <table border="0">
                <tr>
                    <td>
                        Title:
                    </td>
                    <td>
                        <input type="text" name="title" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        From:
                    </td>
                    <td>
                        <input type="text" name="titleFrom" required
                               pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$" title="yyyy-mm-dd" />                   
                    </td>
                </tr>
                <tr>
                    <td>
                        To:
                    </td>
                    <td>
                        <input type="text" name="titleTo" required
                               pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$" title="yyyy-mm-dd" />                   

                    </td>
                </tr>

            </table>
            <hr/>
            <table border="0">
                <tr>
                    <td>
                        Salary
                    </td>
                    <td>
                        <input type="text" name="salary" required
                           pattern="^\d{6}\$"    
                    </td>
                </tr>
                <tr>
                    <td>
                        From:
                    </td>
                    <td>
                        <input type="text" name="salaryFrom" required
                               pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$" title="yyyy-mm-dd" />                   
                    </td>
                </tr>
                <tr>
                    <td>
                        To:
                    </td>
                    <td>
                        <input type="text" name="salaryTo" required
                               pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$" title="yyyy-mm-dd" />                   

                    </td>
                </tr>

            </table>

            <input type ="submit" value="Add Employee"/>
    </center>
</body>
</html>
