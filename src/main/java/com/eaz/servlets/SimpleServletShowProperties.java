package com.eaz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author javier
 */
public class SimpleServletShowProperties extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Simple Servlet Show Properties response</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p><b> request.getAuthType():</b> [" + request.getAuthType() + "]</p>");
            out.println("<p><b> request.getCharacterEncoding():</b> [" + request.getCharacterEncoding() + "]</p>");
            out.println("<p><b> request.getCharacterEncoding():</b> [" + request.getContentType()+ "]</p>");            
            out.println("<p><b> request.getContextPath:</b> [" + request.getContextPath() + "]</p>");
            out.println("<p><b> request.getHeader(\"No header\"):</b> [" + request.getHeader("No header") + "]</p>");
            out.println("<p><b> request.getLocalName():</b> [" + request.getLocalName() + "]</p>");
            out.println("<p><b> request.getLocalAddr():</b> [" + request.getLocalAddr() + "]</p>");
            out.println("<p><b> request.getMethod():</b> [" + request.getMethod() + "]</p>");
            out.println("<p><b> request.getParameter(\"Attribute Test 1\"):</b> [" + request.getParameter("Attribute Test 1") + "]</p>");
            out.println("<p><b> request.getPathInfo():</b> [" + request.getPathInfo() + "]</p>");
            out.println("<p><b> request.getPathTranslated():</b> [" + request.getPathTranslated() + "]</p>");
            out.println("<p><b> request.getProtocol():</b> [" + request.getProtocol() + "]</p>");
            out.println("<p><b> request.getQueryString():</b> [" + request.getQueryString() + "]</p>");
            out.println("<p><b> request.getRemoteAddr():</b> [" + request.getRemoteAddr() + "]</p>");
            
            out.println("<p><b> request.getRemoteHost():</b> [" + request.getRemoteHost() + "]</p>");
            out.println("<p><b> request.getRemoteUser():</b> [" + request.getRemoteUser() + "]</p>");
            out.println("<p><b> request.getRequestURI():</b> [" + request.getRequestURI() + "]</p>");
            out.println("<p><b> request.getRequestedSessionId():</b> [" + request.getRequestedSessionId() + "]</p>");
            out.println("<p><b> request.getScheme():</b> [" + request.getScheme() + "]</p>");
            out.println("<p><b> request.getServerName():</b> [" + request.getServerName() + "]</p>");
            out.println("<p><b> request.getServletPath():</b> [" + request.getServletPath() + "]</p>");
            out.println("<p><b> request.toString:</b> [" + request.toString() + "]</p>");
            out.println("<p><b> request.getAttributeNames():</b> [" + request.getAttributeNames() + "]</p>");            
            {
                out.println("<ol>");
                if (request.getAttributeNames() != null && request.getAttributeNames().hasMoreElements()) {
                    for (Enumeration<String> eAttributeNames = request.getAttributeNames(); request.getAttributeNames().hasMoreElements();) {
                        out.println("<li>[" + eAttributeNames.nextElement() + "]</li>");
                    }
                }
                else {
                    out.println("<li>[No Attribute found]</li>");
                }
                out.println("</ol>");
            }            
            out.println("<p><b> request.getClass().getName():</b> [" + request.getClass().getName() + "]</p>");
            out.println("<p><b> request.request.getContentLength():</b> [" + request.getContentLength() + "]</p>");
            out.println("<p><b> request.getCookies():</b></p>");
            {
                out.println("<ol>");
                if (request.getCookies() != null && request.getCookies().length > 0) {
                    for (Cookie cookie : request.getCookies()) {
                        out.println("<li>[<b>" + cookie.getName() + "</b>] [" + cookie.getValue() + "]</li>");
                    }
                }
                else {
                    out.println("<li>[No Cookie found]</li>");
                }
                out.println("</ol>");
            }            
            out.println("<p><b> request.getHeaderNames():</b></p>");
            {
                out.println("<ol>");
                if (request.getHeaderNames() != null && request.getHeaderNames().hasMoreElements()) {
                    String strHeaderName = "";
                    
                    for (Enumeration<String> eHeaderNames = request.getHeaderNames(); eHeaderNames.hasMoreElements();) {
                        strHeaderName = eHeaderNames.nextElement();
                        if (strHeaderName != null) {
                            out.println("<li>[<b>" + strHeaderName + "</b>] ["+ request.getHeader(strHeaderName) +"]</li>");
                        }                        
                    }
                }
                else {
                    out.println("<li>[No Header name found]</li>");
                }
                out.println("</ol>");
            }            
            out.println("<p><b> request.getHeader(\"host\"):</b> [" + request.getHeader("host") + "]</p>");
            out.println("<p><b> request.getLocalPort():</b> [" + request.getLocalPort() + "]</p>");
            out.println("<p><b> request.getLocale().toString():</b> [" + request.getLocale().toString() + "]</p>");
            out.println("<p><b> request.getLocales():</b></p>");
            {
                out.println("<ol>");
                if (request.getLocales() != null && request.getLocales().hasMoreElements()) {
                    Locale locale = null;
                    for (Enumeration<Locale> eLocale = request.getLocales(); eLocale.hasMoreElements();) {
                        locale = eLocale.nextElement();
                        if (locale != null) {
                            out.println("<li>[" + locale.toString() + "]</li>");
                        }                        
                    }
                }
                else {
                    out.println("<li>[No Locale found]</li>");
                }
                out.println("</ol>");
            }            
            out.println("<p><b> request.getHeader(\"host\"):</b> [" + request.getHeader("host") + "]</p>");
            out.println("<p><b> getInputStream().toString():</b> [" + request.getInputStream().toString() + "]</p>");
            out.println("<p><b> request.getRemotePort():</b> [" + request.getRemotePort() + "]</p>");
            out.println("<p><b> request.getRequestURL().toString():</b> [" + request.getRequestURL().toString() + "]</p>");
            out.println("<p><b> request.getServerPort():</b> [" + request.getServerPort() + "]</p>");
            out.println("<p><b> request.getServletContext().getContextPath():</b> [" + request.getServletContext().getContextPath()+ "]</p>");
            out.println("<p><b> request.getServletContext().getServerInfo():</b> [" + request.getServletContext().getServerInfo() + "]</p>");
            out.println("<p><b> request.getServletContext().getServletContextName():</b> [" + request.getServletContext().getServletContextName() + "]</p>");
            out.println("<p><b> request.getSession().getId():</b> [" + request.getSession().getId() + "]</p>");
            out.println("<p><b> request.getSession().toString():</b> [" + request.getSession().toString() + "]</p>");
            out.println("<p><b> request.hashCode():</b> [" + request.hashCode() + "]</p>");
            out.println("<p><b> request.isAsyncStarted():</b> [" + request.isAsyncStarted() + "]</p>");
            out.println("<p><b> request.isRequestedSessionIdFromCookie():</b> [" + request.isRequestedSessionIdFromCookie() + "]</p>");
            out.println("<p><b> request.isRequestedSessionIdFromURL():</b> [" + request.isRequestedSessionIdFromURL() + "]</p>");
            out.println("<p><b> request.isSecure():</b> [" + request.isSecure() + "]</p>");
            
            out.println("<h4>End SimpleServletShowProperties</h4>");
            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<H3>Method GET invoked</H3"); 
        
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<H3>Method POST invoked</H3");        
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
