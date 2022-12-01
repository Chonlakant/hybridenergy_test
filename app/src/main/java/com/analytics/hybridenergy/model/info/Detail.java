package com.analytics.hybridenergy.model.info;

import com.google.gson.annotations.SerializedName;

   
public class Detail {

   @SerializedName("val")
   String val;

   @SerializedName("ts")
   String ts;


    public void setVal(String val) {
        this.val = val;
    }
    public String getVal() {
        return val;
    }
    
    public void setTs(String ts) {
        this.ts = ts;
    }
    public String getTs() {
        return ts;
    }
    
}