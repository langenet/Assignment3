<%-- 
    Document   : employee
    Created on : 7-Feb-2019, 12:35:13 PM
    Author     : alexr
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
        <style>
            /*
            Source: https://stackoverflow.com/questions/21168521/table-fixed-header-and-scrollable-body
            Author: roko C. Buljan
            date: 2017-12-21
            */

            .tableFixHead    { overflow-y: auto; height: 450px; }
            .tableFixHead th { position: sticky; top: 0; }

            table  { border-collapse: collapse; width: 100%; }
            th, td { padding: 8px 16px; }
            th     { background:#eee; }
        </style>
    </head>
    <body>
        <%@ include file="header.jsp" %>  

    <center>
        <h1>Employees Information and Management</h1>
        <form action ="EmployeeServlet" method ="POST">
            <input type="hidden" value="getById" name="method" />
            Search by Employee Id: <input type="text" name ="empNo"/>
            <input type ="submit" value="submit"/>
            <hr/>
            <a href="${pageContext.request.contextPath}/EmployeeServlet?method=initAdd">
                Add Employee
            </a>
            <br/>
            <br/>
            <div class="tableFixHead">
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Birth Date</th>
                            <th>Gender</th>
                            <th>Hire Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${employees}" var="employee">
                            <tr>
                                <td>
                                    <a href="${pageContext.request.contextPath}/EmployeeServlet?empNo=${employee.empNo}&method=getById">
                                        ${employee.empNo}
                                    </a>
                                </td>
                                <td>
                                    ${employee.firstName}
                                </td>
                                <td>
                                    ${employee.lastName}
                                </td>
                                <td>
                                    ${employee.birthDate}
                                </td>
                                <td>
                                    ${employee.gender}
                                </td>
                                <td>
                                    ${employee.hireDate}
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
        </form>
    </center>
</body>
</html>
