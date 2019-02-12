<%-- 
    Document   : editEmployee
    Created on : 8-Feb-2019, 12:37:37 PM
    Author     : Robert Lange and Alexander Riccio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Employee</title>
    </head>
    <body>
    <center>
        <%@ include file="header.jsp" %>  

        <h1>Edit Employee</h1>

        <form action ="EmployeeServlet" method ="POST">
            <input type="hidden" value="update" name="method" />
            <input type="hidden" value="${employee.empNo}" name="empNo" />
            <hr/>
            <table border="0" cellpadding="5" width="300">
                <tr>
                    <td>
                        First Name: 
                    </td>
                    <td>
                        <input type="text" value="${employee.firstName}" name="firstName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Last Name: 
                    </td>
                    <td>
                        <input type="text"  value="${employee.lastName}" name="lastName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Birth Date: 
                    </td>
                    <td>
                        <input type="text"  value="${employee.birthDate}" name="birthDate"
                               pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$" title="yyyy-mm-dd" /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Gender: 
                    </td>
                    <td>
                        <select name="gender" value="$(employee.gender}">

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
                        <input type="text"  value="${employee.hireDate}" name="hireDate"
                               pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$" title="yyyy-mm-dd" /> 
                    </td>
                </tr>
            </table>
            <input type ="submit" value="Update Employee"/>
    </center>
</body>
</html>
