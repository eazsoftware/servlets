package com.eaz.servlets.session.stockmarket;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author javier
 */
public class StockMarketTest {
    
    public StockMarketTest() {
    }
    
    @Test
    public void buyStocks() {
        StockMarket stockMarket = StockMarket.getInstance();
        
        StockCart stockCart1 = new StockCart(1000.0f);
        
        assertTrue(stockMarket.reSell(stockCart1, "Apple1"));
        assertTrue(stockMarket.reSell(stockCart1, "Apple2"));
        assertTrue(stockMarket.reSell(stockCart1, "Apple3"));
        
        assertTrue(stockMarket.reSell(stockCart1, "Microsoft1"));
        assertTrue(stockMarket.reSell(stockCart1, "Microsoft2"));
        
        assertTrue(stockMarket.reSell(stockCart1, "Google1"));
        
        assertNotNull(stockCart1.getlStock());
        
        assertTrue(stockCart1.getlStock().size() == 6);
        
        float fBudgetBefore = stockCart1.getfBudget();
        
        assertTrue(stockMarket.reBuy(stockCart1, "Apple1"));
        
        assertTrue(stockCart1.getlStock().size() == 5);
        
        float fBudgetAfter = stockCart1.getfBudget();     
        
        assertTrue(fBudgetAfter > fBudgetBefore);
        
        
    }

}