package com.analytics.hybridenergy.model;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class Dat {

   @SerializedName("keys")
   List<String> keys;


    public void setKeys(List<String> keys) {
        this.keys = keys;
    }
    public List<String> getKeys() {
        return keys;
    }
    
}