<%-- 
    Document   : department
    Created on : Feb 9, 2019, 5:04:13 PM
    Author     : Robert Lange and Alexander Riccio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Department Page</title>
        <style>
            /*
            Source: https://stackoverflow.com/questions/21168521/table-fixed-header-and-scrollable-body
            Author: roko C. Buljan
            date: 2017-12-21
            */

            .tableFixHead    { overflow-y: auto; height: 450px; }
            .tableFixHead th { position: sticky; top: 0; }

            table  { border-collapse: collapse; width: 35%; }
            th, td { padding: 8px 16px; }
            th     { background:#eee; }
        </style>
    </head>
    <body>
        <%@ include file="header.jsp" %>  

    <center>
        <h1>Departments</h1>
        <hr/>
        <br/>
        <div style="tableFixHead">
            <table border="1">
                <thead>
                    <tr>
                        <th>Department ID</th>
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
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </center>
</body>
</html>