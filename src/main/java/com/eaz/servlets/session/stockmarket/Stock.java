package com.eaz.servlets.session.stockmarket;

/**
 *
 * @author javier
 */
public class Stock {
    
    private String strId;
    private String strCompany;
    private boolean bAvailable;
    private float fPrice;
    
    public Stock() {
    
    }
    
    public Stock( String strId,
            String strCompany,
            boolean bAvailable,
            float fPrice) {
        this.strId = strId;
        this.strCompany = strCompany;
        this.bAvailable = bAvailable;
        this.fPrice = fPrice;
    }

    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId;
    }
    
    public String getStrCompany() {
        return strCompany;
    }

    public void setStrCompany(String strCompany) {
        this.strCompany = strCompany;
    }

    public boolean isbAvailable() {
        return bAvailable;
    }

    public void setbAvailable(boolean bAvailable) {
        this.bAvailable = bAvailable;
    }

    public float getfPrice() {
        return fPrice;
    }

    public void setfPrice(float fPrice) {
        this.fPrice = fPrice;
    }
            
}