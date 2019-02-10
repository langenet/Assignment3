<%-- 
    Document   : salary
    Created on : 9-Feb-2019, 11:29:34 PM
    Author     : alexr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salaries</title>
    </head>
    <body>
    <center>
        <h1>Salaries</h1>
        <form action ="DepartmentEmployeeServlet" method ="POST">
            <!--            <input type="hidden" value="getById" name="method" />
                        Search by Department Manager Id: <input type="text" name ="deptNo"/>
                        <input type ="submit" value="submit"/>-->
            <hr/>
<!--            <a href="${pageContext.request.contextPath}/addDepartment.jsp">
                Add Department
            </a>-->
            <br/>
            <table border="1">
                <thead>
                    <tr>
                        <th>Employee Id</th>
                        <th>Salary</th>
                        <th>From Date</th>
                        <th>To Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${salaries}" var="salary">
                        <tr>
                            <td>
                                ${salary.empNo}
                            </td>
                            <td>
                                ${salary.salary}
                            </td>
                            <td>
                                ${salary.fromDate}
                            </td>
                            <td>
                                ${salary.toDate}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
    </center>
        </form>    </body>
</html>
