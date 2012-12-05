package com.eaz.servlets.cookie;

/**
 *
 * @author javier
 */
import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class CookieServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(true);
        
        response.setContentType("text/html");
        
        /*
        String strWelcome = "Welcome back";
        if (session.isNew()) {
            strWelcome = "Welcome";
        }
        
        Integer iAccess = 
                Integer.parseInt( session.getAttribute("iNumAccess") != null ? session.getAttribute("iNumAccess").toString() : "0" ) ;
        */
        Random randomGenerator = new Random();
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Cookie cookie = new Cookie("CookieServlet", "CookieServlet Information created on: ["+new Date()+"]");
        cookie.setComment("Cookie comment");
        //cookie.setDomain("localhost");
        cookie.setPath("/Servlets");
        cookie.setMaxAge(60 * 2);        
        cookie.setSecure(false);
        cookie.setHttpOnly(true);
        cookie.setVersion(1);
        
        response.addCookie(cookie);
        
        response.sendRedirect("view/cookie/cookieResponse.jsp");
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