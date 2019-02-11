<%-- 
    Document   : addDepartment
    Created on : Feb 9, 2019, 9:22:42 PM
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Department</title>
    </head>

    <body>
        <%@ include file="header.jsp" %>  

        <h1>Add Employee</h1>

        <form action ="EmployeeServlet" method ="POST">
            <input type="hidden" value="add" name="method" />
            <hr/>
            <table border="0" cellpadding="5" width="300">
                <tr>
                    <td>
                        Department Number: 
                    </td>
                    <td>
                        <input type="text" name="deptNum" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Department Name:
                    </td>
                    <td>
                        <input type="text" name="deptName" required/>
                    </td>
                </tr>              
            </table>
            <input type ="submit" value="Add Department"/>

    </body>
</html>
>
