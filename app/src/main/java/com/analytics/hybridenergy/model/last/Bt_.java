package com.analytics.hybridenergy.model.last;

import com.google.gson.annotations.SerializedName;

   
public class Bt_ {

   @SerializedName("id")
   String id;

   @SerializedName("par")
   String par;

   @SerializedName("val")
   String val;

   @SerializedName("unit")
   String unit;


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
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getUnit() {
        return unit;
    }
    
}