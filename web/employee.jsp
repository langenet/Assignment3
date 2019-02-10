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
    </head>
    <body>
        <h1>Hello Employees!</h1>
        <form action ="EmployeeServlet" method ="POST">
            <input type="hidden" value="getById" name="method" />
            Search by Employee Id: <input type="text" name ="empNo"/>
            <input type ="submit" value="submit"/>
            <hr/>
            <a href="${pageContext.request.contextPath}/EmployeeServlet?method=initAdd">
                Add Employee
            </a>
            <br/>
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

        </form>



    </body>
</html>
