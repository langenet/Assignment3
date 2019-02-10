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
            <input type ="submit" value="Add Employee"/>

    </body>
</html>