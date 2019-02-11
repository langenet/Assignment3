<%-- 
    Document   : viewDepartments
    Created on : Feb 9, 2019, 2:45:07 PM
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Department Page</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>  

    <center>
        <h1>Department Page</h1>
        <form action ="DepartmentServlet" method ="POST">
            <input type="hidden" value="getById" name="method" />
            Search by Department Id: <input type="text" name ="deptNo"/>
            <input type ="submit" value="submit"/>
            <hr/>
<!--            <a href="${pageContext.request.contextPath}/addDepartment.jsp">
                Add Department
            </a>-->
            <br/>
            <table border="1">
                <thead>
                    <tr>
                        <th>Department Number</th>
                        <th>Department Name</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${departments}" var="department">
                    <tr>
                        <td>
                            <a href="${pageContext.request.contextPath}/DepartmentServlet?deptNo=${department.deptNo}&method=getById">
                                ${department.deptNo}
                            </a>
                        </td>
                        <td>
                            ${department.deptName}
                        </td
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </form>


    </center>
</body>
</html>
