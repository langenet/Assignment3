<%-- 
    Document   : departmentEmployee
    Created on : 9-Feb-2019, 10:51:45 PM
    Author     : alexr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Department Employees</title>
    </head>
    <body>
        <h1>Department Employees</h1>
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
                        <th>Department Employee Id</th>
                        <th>Department No</th>
                        <th>From Date</th>
                        <th>To Date</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${departmentEmployees}" var="departmentEmployee">
                    <tr>
                        <td>
                            ${departmentEmployee.empNo}
                        </td>
                        <td>
                            ${departmentEmployee.deptNo}
                        </td>
                        <td>
                            ${departmentEmployee.fromDate}
                        </td>
                        <td>
                            ${departmentEmployee.toDate}
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </form>
    </body>
</html>
