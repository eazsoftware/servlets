package com.eaz.servlets.session.stockmarket;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javier
 */
public class StockCart {
   
    private float fBudget;
    private List<Stock> lStock;
    
    public StockCart() {
        this.lStock = new ArrayList<Stock>();
    }
    
    public StockCart(float fBudget) {
        this();
        this.fBudget = fBudget;
    }

    public float getfBudget() {
        return fBudget;
    }

    public void setfBudget(float fBudget) {
        this.fBudget = fBudget;
    }

    public List<Stock> getlStock() {
        return lStock;
    }

    public void setlStock(List<Stock> lStock) {
        this.lStock = lStock;
    }
    
    public boolean addStock(Stock stock) {
        boolean bResult = false;
        
        if (this.lStock != null) {
            bResult = this.lStock.add(stock);
        }
        
        return bResult;
    }

    public boolean removeStock(Stock stock) {
        boolean bResult = false;
        
        if (this.lStock != null) {
            bResult = this.lStock.remove(stock);
        }
        
        return bResult;
    }    
    
}