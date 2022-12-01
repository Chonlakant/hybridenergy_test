package com.analytics.hybridenergy.model.info;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class Dat {

   @SerializedName("detail")
   List<Detail> detail;


    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }
    public List<Detail> getDetail() {
        return detail;
    }
    
}