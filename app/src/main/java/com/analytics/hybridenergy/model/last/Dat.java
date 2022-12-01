package com.analytics.hybridenergy.model.last;

import com.google.gson.annotations.SerializedName;

   
public class Dat {

   @SerializedName("gts")
   String gts;

   @SerializedName("pars")
   Pars pars;


    public void setGts(String gts) {
        this.gts = gts;
    }
    public String getGts() {
        return gts;
    }
    
    public void setPars(Pars pars) {
        this.pars = pars;
    }
    public Pars getPars() {
        return pars;
    }
    
}