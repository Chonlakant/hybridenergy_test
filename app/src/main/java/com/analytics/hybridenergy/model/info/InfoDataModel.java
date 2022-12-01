package com.analytics.hybridenergy.model.info;

import com.google.gson.annotations.SerializedName;

   
public class InfoDataModel {

   @SerializedName("err")
   int err;

   @SerializedName("desc")
   String desc;

   @SerializedName("dat")
   Dat dat;


    public void setErr(int err) {
        this.err = err;
    }
    public int getErr() {
        return err;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
    
    public void setDat(Dat dat) {
        this.dat = dat;
    }
    public Dat getDat() {
        return dat;
    }
    
}