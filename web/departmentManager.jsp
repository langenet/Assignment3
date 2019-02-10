<%-- 
    Document   : departmentManager.jsp
    Created on : 9-Feb-2019, 10:45:44 PM
    Author     : alexr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Department Managers</title>
    </head>
    <body>
    <center>
        <h1>Department Managers</h1>
        <form action ="DepartmentManagerServlet" method ="POST">
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
                        <th>Department No</th>
                        <th>From Date</th>
                        <th>To Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${departmentManagers}" var="departmentManager">
                        <tr>
                            <td>
                                ${departmentManager.empNo}
                            </td>
                            <td>
                                ${departmentManager.deptNo}
                            </td>
                            <td>
                                ${departmentManager.fromDate}
                            </td>
                            <td>
                                ${departmentManager.toDate}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </form>
    </center>
    </body>
</html>
