package com.eaz.servlets.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author javier
 */
public class SessionServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        
        try {
            String strOperation = request.getParameter("operation");

            if ("close".equals(strOperation)) {
                session.invalidate();
                response.sendRedirect("view/session/sessionServlet.jsp");
            }
            else {
                String strHeading = null;
                Integer iAccessCount = new Integer(0);

                if (session.isNew()) {
                    strHeading = "Welcome newcomer";
                }
                else {
                    strHeading = "Welcome again";
                    iAccessCount = (Integer) session.getAttribute("accessCount");
                    if (iAccessCount == null) {
                        iAccessCount = new Integer(0);
                    }
                    iAccessCount++;
                }

                session.setAttribute("accessCount", iAccessCount);

                /* TODO output your page here. You may use following sample code. */
                out.println("<html>");
                out.println("<head>");
                    out.println("<title>Servlet SessionServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                    out.println("<h1>" + strHeading + "</h1>");
                    out.println("<h2>Session information</h2>");
                    out.println("<table>");
                        out.println("<tr>");
                            out.println("<th>Info type</th>");
                            out.println("<th>Value</th>");
                        out.println("</tr>");
                        out.println("<tr>");
                            out.println("<td>ID</td>");
                            out.println("<td>"+session.getId()+"</td>");
                        out.println("<tr>");
                        out.println("<tr>");
                            out.println("<td>Creation time</td>");
                            out.println("<td>"+ new Date (session.getCreationTime()) +"</td>");
                        out.println("<tr>");                   
                        out.println("<tr>");
                            out.println("<td>Creation time</td>");
                            out.println("<td>"+ new Date (session.getLastAccessedTime()) +"</td>");
                        out.println("<tr>");  
                        out.println("<tr>");
                            out.println("<td>Number of accesses</td>");
                            out.println("<td>"+ session.getAttribute("accessCount") +"</td>");
                        out.println("<tr>");                                       
                    out.println("</table>");            
                out.println("</tr>");
                out.println("</table>");
                out.println("<form action=\"/Servlets/SessionServlet\" method=\"get\">");
                    out.println("<input type=\"hidden\" name=\"operation\" value=\"close\" />");
                    out.println("<input type=\"submit\" value=\"Close session\" />");
                out.println("</form>");            
                out.println("</body>");
                out.println("</html>");            
            }
        }
        finally {            
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
