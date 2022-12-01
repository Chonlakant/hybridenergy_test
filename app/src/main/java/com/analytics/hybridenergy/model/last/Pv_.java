package com.analytics.hybridenergy.model.last;

import com.google.gson.annotations.SerializedName;

   
public class Pv_ {

   @SerializedName("id")
   String id;

   @SerializedName("par")
   String par;

   @SerializedName("val")
   String val;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    
    public void setPar(String par) {
        this.par = par;
    }
    public String getPar() {
        return par;
    }
    
    public void setVal(String val) {
        this.val = val;
    }
    public String getVal() {
        return val;
    }
    
}