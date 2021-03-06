<%-- 
    Document   : viewEmployee
    Created on : 7-Feb-2019, 8:48:08 PM
    Author     : Robert Lange and Alexander Riccio
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

    <center>

        <%@ include file="header.jsp" %>  
        <h1>Employee Information</h1>

        <p><a href="${pageContext.request.contextPath}/EmployeeServlet?method=edit&empNo=${employee.empNo}">
                Edit Employee</a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</p>


        <p><a class="confirmDelete" href="${pageContext.request.contextPath}/EmployeeServlet?method=delete&empNo=${employee.empNo}">
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

    </center>
</body>
</html>
    <script>

        /*
         * source: https://stackoverflow.com/questions/10462839/how-to-display-a-confirmation-dialog-when-clicking-an-a-link
         * author: kapa
         * date: 2012-05-05
         */
        var elems = document.getElementsByClassName('confirmDelete');
        var confirmIt = function (e) {
            if (!confirm('Are you sure you want to delete this employee?'))
                e.preventDefault();
        };
        for (var i = 0, l = elems.length; i < l; i++) {
            elems[i].addEventListener('click', confirmIt, false);
        }
    </script> 