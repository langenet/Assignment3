<%-- 
    Document   : addEmployee
    Created on : 8-Feb-2019, 9:30:28 AM
    Author     : alexr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employee</title>
    </head>
    <body>
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
                        <input type="text" name="firstName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Last Name: 
                    </td>
                    <td>
                        <input type="text" name="lastName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Birth Date: 
                    </td>
                    <td>
                        <input type="text" name="birthDate"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Gender: 
                    </td>
                    <td>
                        <input type="text" name="gender"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Hire Date: 
                    </td>
                    <td>
                        <input type="text" name="hireDate"/>
                    </td>
                </tr>
            </table>
            <input type ="submit" value="Add Employee"/>

    </body>
</html>
