<%-- 
    Document   : stockmarket.jsp
    Created on : 16-Dec-2012, 22:04:30
    Author     : javier
--%>

<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="com.eaz.servlets.session.stockmarket.Stock"%>
<%@page import="com.eaz.servlets.session.stockmarket.StockCart"%>

<% 
    StockCart stockCart = (StockCart) request.getSession().getAttribute("stockCart");
    Map<String, Stock> stocks = (Map<String, Stock>) request.getSession().getAttribute("stocks");
    String strMessage = (String) request.getSession().getAttribute("message");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stock Market</title>
    </head>
    <body>
        <h1>Stock Market</h1>
        
        <% 
        if (stockCart != null) {
        %> 
            <h4><a href="/Servlets/StockMarketServlet?operation=close">Close session in Stock Market</a></h4>
            <%
            if (stockCart.getlStock() != null && !stockCart.getlStock().isEmpty()) {
            %>
                <table>
                    <tr>
                        <th>Stock</th>
                        <th>Price</th>
                        <th>Sell</th>
                    </tr>                    
                    <%
                    for (Stock stock : stockCart.getlStock()) {
                    %>
                        <tr>
                            <td><%=stock.getStrCompany()%></td>
                            <td><%=stock.getfPrice()%></td>
                            <td>
                                <form action="/Servlets/StockMarketServlet">
                                    <input type="hidden" name="operation" value="sell" />
                                    <input type="hidden" name="stockID" value="<%=stock.getStrId()%>" />
                                    <input type="submit" name="Sell" value="sell" onclick="submit" />
                                </form>
                            </td>
                        </tr>
                    <%
                    } 
                %>

                </table>
                <%
            }
            else {
                %>
                <p>No stocks in the cart.</p>
                <%
            }
            
            %>
            <h4>Current budget: <%=stockCart.getfBudget()%></a></h4>   
            <%
            
            if (stocks != null) {
                Iterator<Entry<String, Stock>> iterator = stocks.entrySet().iterator();
                if (iterator.hasNext()) {
                    %>
                    <table>
                        <tr>
                            <th>Stock</th>
                            <th>Price</th>
                            <th>Buy</th>
                        </tr>                    
                    <%
                    do {
                        Entry<String, Stock> entry = iterator.next();
                        if (entry.getValue().isbAvailable()) {
                            %>
                            <tr>
                                <td><%=entry.getValue().getStrCompany()%></td>
                                <td><%=entry.getValue().getfPrice()%></td>
                                <td>
                                    <form action="/Servlets/StockMarketServlet">
                                        <input type="hidden" name="operation" value="buy" />
                                        <input type="hidden" name="stockID" value="<%=entry.getValue().getStrId()%>" />
                                        <input type="submit" name="Buy" value="Buy" onclick="submit" />
                                    </form>
                                </td>
                            </tr>
                            <%
                        }
                    } while (iterator.hasNext());
                    %>
                    </table>
                    <%
                }
            }        
        }
        else {
        %>
            <h4><a href="/Servlets/StockMarketServlet?operation=create">Create session in Stock Market</a></h4>
        <%
        }
        %>
        
        <% 
        if (strMessage != null) {
            %>
            <p><i><%=strMessage%></i></p>
            <%
        }
        %>
    </body>
    
    
</html>
