package com.analytics.hybridenergy.model.last;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class Pars {

   @SerializedName("gd_")
   List<Gd_> gd_;

   @SerializedName("sy_")
   List<Sy_> sy_;

   @SerializedName("pv_")
   List<Pv_> pv_;

   @SerializedName("bt_")
   List<Bt_> bt_;

   @SerializedName("bc_")
   List<Bc_> bc_;


    public void setGd_(List<Gd_> gd_) {
        this.gd_ = gd_;
    }
    public List<Gd_> getGd_() {
        return gd_;
    }
    
    public void setSy_(List<Sy_> sy_) {
        this.sy_ = sy_;
    }
    public List<Sy_> getSy_() {
        return sy_;
    }
    
    public void setPv_(List<Pv_> pv_) {
        this.pv_ = pv_;
    }
    public List<Pv_> getPv_() {
        return pv_;
    }
    
    public void setBt_(List<Bt_> bt_) {
        this.bt_ = bt_;
    }
    public List<Bt_> getBt_() {
        return bt_;
    }
    
    public void setBc_(List<Bc_> bc_) {
        this.bc_ = bc_;
    }
    public List<Bc_> getBc_() {
        return bc_;
    }
    
}