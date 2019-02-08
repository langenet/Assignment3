<%-- 
    Document   : viewEmployee
    Created on : 7-Feb-2019, 8:48:08 PM
    Author     : alexr
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Employee Record</title>
    </head>
    <body>
        <h1>${employee.firstName} ${employee.lastName}</h1>
        <table border="0" cellpadding="5" width="300">
            <tr>
                <td>
                    Employee Id: 
                </td>
                <td>
                    ${employee.empNo}
                </td>
            </tr>
            <tr>
                <td>
                    Birth Date: 
                </td>
                <td>
                    ${employee.birthDate}
                </td>
            </tr>
            <tr>
                <td>
                    Gender: 
                </td>
                <td>
                    ${employee.gender}
                </td>
            </tr>
            <tr>
                <td>
                    Hire Date: 
                </td>
                <td>
                    ${employee.hireDate}
                </td>
            </tr>
        </table>
    </body>
</html>
