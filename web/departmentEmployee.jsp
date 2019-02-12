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
        <style>
            /*
            Source: https://stackoverflow.com/questions/21168521/table-fixed-header-and-scrollable-body
            Author: roko C. Buljan
            date: 2017-12-21
            */

            .tableFixHeaddeptEmp    { overflow-y: auto; height: 250px; }
            .tableFixHeaddeptEmp th { position: sticky; top: 0; }

            table  { border-collapse: collapse; width: 75%; }
            th, td { padding: 8px 16px; }
            th     { background:#eee; }
        </style>
    </head>
    <body>
        <%@ include file="header.jsp" %>  

    <center>
        <h1>Department Employees</h1>
        <form action ="DepartmentEmployeeServlet" method ="POST">
            <hr/>
            <br/>
            <div style="tableFixHeaddeptEmp">
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
            </div>
        </form>
    </center>
</body>
</html>
