<%-- 
    Document   : simpleServletShowProperties
    Created on : 01-Dec-2012, 14:05:58
    Author     : javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Servlet show properties</title>
    </head>
    <body>
        <h1>Simple Servlet show properties</h1>
        
        <% 
            pageContext.setAttribute("Attribute Test 1", "Attribute Test 1");
            pageContext.setAttribute("Attribute Test 2", "Attribute Test 2");            
        %>        
        <form action="/Servlets/SimpleServletShowProperties" method="GET">
            <input type="hidden" name="Attribute Test 3" value="Attribute Test 3" />
            <input type="submit" value="Call Simple Servlet show properties GET"/>
        </form>
    </body>
</html>
