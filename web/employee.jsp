<%-- 
    Document   : employee
    Created on : 7-Feb-2019, 12:35:13 PM
    Author     : alexr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
    </head>
    <body>
                <h1>Hello Employees!</h1>
        <form action ="employee.jsp" method ="GET">
            Employee Id: <input type="text" name ="empNo"/>
            <br/>
            <input type ="submit" value="submit"/>
        </form>

    </body>
</html>
