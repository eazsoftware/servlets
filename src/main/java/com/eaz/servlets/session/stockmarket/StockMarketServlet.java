package com.eaz.servlets.session.stockmarket;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author javier
 */
public class StockMarketServlet extends HttpServlet {
    
    private static StockMarket stockMarket;
    
    static {
        stockMarket = StockMarket.getInstance();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(true);
        try {
            String strOperation = request.getParameter("operation");
            StockCart stockCart = null;
            String strStockID = null;
            
            request.getSession().removeAttribute("message");
            
            System.out.println("StockMarketServlet.operation ==> " + strOperation);
            
            if ("buy".equals(strOperation)) {
                stockCart = (StockCart) request.getSession().getAttribute("stockCart");
                strStockID = request.getParameter("stockID");                
                
                if (StockMarketServlet.stockMarket.reSell(stockCart, strStockID)) {
                    request.getSession().setAttribute("message", "Stock ["+strStockID+"] bought");
                }
                else {
                    request.getSession().setAttribute("message", "Stock ["+strStockID+"] not bought");
                }
                
                request.getSession().setAttribute("stocks", stockMarket.getaStocks());
            }
            else if ("sell".equals(strOperation)) {
                stockCart = (StockCart) request.getSession().getAttribute("stockCart");
                strStockID = request.getParameter("stockID");
                
                if (StockMarketServlet.stockMarket.reBuy(stockCart, strStockID)) {
                    request.getSession().setAttribute("message", "Stock ["+strStockID+"] sold");
                }
                else {
                    request.getSession().setAttribute("message", "Stock ["+strStockID+"] not sold");
                }
                
                request.getSession().setAttribute("stocks", stockMarket.getaStocks());
            }
            else if ("create".equals(strOperation)) {
                stockCart = new StockCart(300.00f);
                request.getSession().setAttribute("stockCart", stockCart);
                request.getSession().setAttribute("message", "Session created successfully");
                request.getSession().setAttribute("stocks", stockMarket.getaStocks());                
            }
            else if ("close".equals(strOperation)){
                stockMarket.releaseStocks(stockCart);
                request.getSession().invalidate();
            }
            
            response.sendRedirect("view/stockmarket/stockmarket.jsp");
        } finally {            
            
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

