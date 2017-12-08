<%@ taglib prefix = "ex" uri = "WEB-INF/custom.tld"%>
<%-- 
    Document   : specialty
    Created on : Oct 2, 2017, 9:15:02 AM
    Author     : Serikov S.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
        <script>
        </script>
    </head>
    <body>
        <%
            String id = request.getParameter("specid");
        %>
        <ex:Specialty id= "<%= id %>" />
    </body>
</html>
