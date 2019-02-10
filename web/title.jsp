<%-- 
    Document   : title
    Created on : 9-Feb-2019, 11:46:36 PM
    Author     : alexr
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Titles</title>
    </head>
    <body>
        <h1>Employee Titles</h1>
        <form action ="TitleServlet" method ="POST">
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
                        <th>Title</th>
                        <th>From Date</th>
                        <th>To Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${titles}" var="title">
                        <tr>
                            <td>
                                ${title.empNo}
                            </td>
                            <td>
                                ${title.title}
                            </td>
                            <td>
                                ${title.fromDate}
                            </td>
                            <td>
                                ${title.toDate}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </form>
    </body>
</html>
