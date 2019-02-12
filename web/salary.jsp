<%-- 
    Document   : salary
    Created on : 9-Feb-2019, 11:29:34 PM
    Author     : Robert Lange and Alexander Riccio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salaries</title>
        <style>
            /*
            Source: https://stackoverflow.com/questions/21168521/table-fixed-header-and-scrollable-body
            Author: roko C. Buljan
            date: 2017-12-21
            */

            .tableFixHead    { overflow-y: auto; height: 450px; }
            .tableFixHead th { position: sticky; top: 0; }

            table  { border-collapse: collapse; width: 75%; }
            th, td { padding: 8px 16px; }
            th     { background:#eee; }
        </style>
    </head>
    <body>
        <%@ include file="header.jsp" %>  

    <center>
        <h1>Salaries</h1>
        <form action ="DepartmentEmployeeServlet" method ="POST">
            <hr/>
            <br/>
            <div style="tableFixHead">

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
            </div>
    </center>
</form>    
</body>
</html>
