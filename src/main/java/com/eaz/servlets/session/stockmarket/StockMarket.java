package com.eaz.servlets.session.stockmarket;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author javier
 */
public class StockMarket {
    
    private static int I_MAX_STOCKS = 5;
    
    private static String STR_APPLE = "Apple";
    private static String STR_GOOGLE = "Google";
    private static String STR_MICROSOFT = "Microsoft";

    private Map<String, Stock> aStocks;
    
    private StockMarket(){
        this.initialize();
    }
    
    /**
     * http://en.wikipedia.org/wiki/Singleton_pattern#The_solution_of_Bill_Pugh
     * 
     * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
     * or the first access to SingletonHolder.INSTANCE, not before.
     */
    private static class SingletonHolder {
        public static final StockMarket INSTANCE = new StockMarket();
    }

    public static StockMarket getInstance() {
        return SingletonHolder.INSTANCE;
    }  
    
    private void initialize() {
        this.aStocks = new HashMap<String, Stock>();
        for(int i=0; i<I_MAX_STOCKS; i++) {
            this.getaStocks().put( STR_APPLE + i,
                new Stock(STR_APPLE + i, STR_APPLE, true, this.randomPrice(50.0f, 100.0f)));

            this.getaStocks().put( STR_GOOGLE + i,
                new Stock(STR_GOOGLE + i, STR_GOOGLE, true, this.randomPrice(50.0f, 100.0f)));

            this.getaStocks().put( STR_MICROSOFT + i,
                new Stock(STR_MICROSOFT + i, STR_MICROSOFT, true, this.randomPrice(50.0f, 100.0f)));        
        }
    }
    
    public boolean reBuy(StockCart stockCart, String strStockID) {
        boolean bResult = false;
        
        if (strStockID != null) {            
            if (getaStocks() != null) {
                if (getaStocks().containsKey(strStockID)) {
                    Stock stockTemp = getaStocks().get(strStockID);
                    if (!stockTemp.isbAvailable()) {
                        getaStocks().remove(strStockID);
                        stockTemp.setbAvailable(Boolean.TRUE);
                        getaStocks().put(strStockID, stockTemp);
                        
                        stockCart.setfBudget(stockCart.getfBudget() + stockTemp.getfPrice());
                        bResult = stockCart.removeStock(stockTemp);                        
                    }
                }
            }
        }
        
        return bResult;
    }

    public boolean reSell(StockCart stockCart, String strStockID) {
        boolean bResult = false;
        
        if (strStockID != null) {            
            if (getaStocks() != null) {
                if (getaStocks().containsKey(strStockID)) {
                    Stock stockTemp = getaStocks().get(strStockID);
                    if (stockTemp != null &&
                            stockTemp.isbAvailable() && 
                            this.canBePaid(stockCart, stockTemp)) {
                        getaStocks().remove(strStockID);
                        stockTemp.setbAvailable(Boolean.FALSE);
                        getaStocks().put(strStockID, stockTemp);
                        
                        stockCart.setfBudget(stockCart.getfBudget() - stockTemp.getfPrice());
                        bResult = stockCart.addStock(stockTemp);
                    }
                }
            }
        }
        
        return bResult;
    }
    
    public void releaseStocks(StockCart stockCart) {
        if (stockCart != null && stockCart.getlStock() != null) {
            for (Stock stock : stockCart.getlStock()) {
                this.reBuy(stockCart, stock.getStrId());
            }
        }
    }
    
    private boolean canBePaid(StockCart stockCart, Stock stock) {
        boolean bResult = false;
        
        if (stockCart != null && stock != null) {
            bResult = stockCart.getfBudget() >= stock.getfPrice();
        }
        
        return bResult;
    }
    
    private float randomPrice(float min, float max) {
        return min + ( (float) Math.random() * (max - min));
    }    
 
    /**
     * @return the aStocks
     */
    public Map<String, Stock> getaStocks() {
        return aStocks;
    }
}