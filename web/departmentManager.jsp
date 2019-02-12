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
        <h1>Department Managers</h1>
        <form action ="DepartmentManagerServlet" method ="POST">
            <hr/>
            <br/>
            <div style="tableFixHead">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Manager Id</th>
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
            </div>
        </form>
    </center>
</body>
</html>
