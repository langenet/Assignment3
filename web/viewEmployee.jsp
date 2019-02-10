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
<style>
p {
  display: inline;
}
</style>
    <body>
        <h1>Employee Information</h1>

        <p><a href="${pageContext.request.contextPath}/EmployeeServlet?method=edit&empNo=${employee.empNo}">
                Edit Employee</a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</p>
        
          
                <p><a href="${pageContext.request.contextPath}/EmployeeServlet?method=delete&empNo=${employee.empNo}">
                        Delete Employee</a></p>
        
        <br/>
        <table border="0" cellpadding="5" width="300">
            <tr>
                <td>
                    First Name:
                </td>
                <td>
                    ${employee.firstName}
                </td>
            </tr>
            <tr>
                <td>
                    Last Name:
                </td>
                <td>
                    ${employee.lastName}
                </td>
            </tr>
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
