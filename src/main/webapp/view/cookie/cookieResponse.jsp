<%-- 
    Document   : cookieResponse
    Created on : 05-Dec-2012, 23:24:06
    Author     : javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cookie response</title>
    </head>
    <body>
        <%
        Cookie[] cCookies = request.getCookies();
        if (cCookies != null) {
            for (Cookie tmpCookie : cCookies) {
                out.println("<p>Cookie: " + tmpCookie.getName() + "["+tmpCookie.getComment()+"]["+tmpCookie.getDomain()+"]["+tmpCookie.getPath()+"]["+tmpCookie.getValue()+"]["+tmpCookie.getMaxAge()+"]["+tmpCookie.getVersion()+"]</p>");
                out.println(tmpCookie.toString());
            }
        }
        
        out.println("<form action=\"/Servlets/CookieServlet\" method=\"get\">");
        out.println("<input type=\"submit\" value=\"Create cookie\"/>");
        out.println("</form>");        
        
        out.println("</body>");
        out.println("</html>");
        %>
    </body>
</html>
