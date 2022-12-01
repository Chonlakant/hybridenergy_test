package com.analytics.hybridenergy;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.List;

public class SataionModel implements Serializable {
  private String msg;

  private Integer total;

  private Integer total_renac;

  private String code;

  private Boolean success;

  private String requestId;

  private Integer total_hybridpro;

  private String hybridpro_secret;

  private List<? extends StationList_hybridpro> stationList_hybridpro;

  private String hybridpro_token;

  public String getMsg() {
    return this.msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Integer getTotal() {
    return this.total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Integer getTotal_renac() {
    return this.total_renac;
  }

  public void setTotal_renac(Integer total_renac) {
    this.total_renac = total_renac;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Boolean getSuccess() {
    return this.success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public String getRequestId() {
    return this.requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public Integer getTotal_hybridpro() {
    return this.total_hybridpro;
  }

  public void setTotal_hybridpro(Integer total_hybridpro) {
    this.total_hybridpro = total_hybridpro;
  }

  public String getHybridpro_secret() {
    return this.hybridpro_secret;
  }

  public void setHybridpro_secret(String hybridpro_secret) {
    this.hybridpro_secret = hybridpro_secret;
  }

  public List<? extends StationList_hybridpro> getStationList_hybridpro() {
    return this.stationList_hybridpro;
  }

  public void setStationList_hybridpro(List<? extends StationList_hybridpro> stationList_hybridpro) {
    this.stationList_hybridpro = stationList_hybridpro;
  }

  public String getHybridpro_token() {
    return this.hybridpro_token;
  }

  public void setHybridpro_token(String hybridpro_token) {
    this.hybridpro_token = hybridpro_token;
  }

  public static class StationList_hybridpro implements Serializable {
    private String fireware;

    private String buyProfit;

    private String timezone;

    private Integer allPowerGeneration;

    private String pid;

    private String unitProfit;

    private Double unitprice;

    private Integer deviceId;

    private Integer plan_list_id;

    private String uid;

    private String load;

    private String balance;

    private String usr;

    private String alias;

    private Object name_solarapp;

    private String currency;

    private String plan_list_created;

    private String sn;

    private String signal;

    private String electric_meter_type;

    private String pname;

    private Object model_id;

    private String sellProfit;

    private String devaddr;

    private String devcode;

    private String descx;

    private String pn;

    private String did;

    private String status;

    public String getFireware() {
      return this.fireware;
    }

    public void setFireware(String fireware) {
      this.fireware = fireware;
    }

    public String getBuyProfit() {
      return this.buyProfit;
    }

    public void setBuyProfit(String buyProfit) {
      this.buyProfit = buyProfit;
    }

    public String getTimezone() {
      return this.timezone;
    }

    public void setTimezone(String timezone) {
      this.timezone = timezone;
    }

    public Integer getAllPowerGeneration() {
      return this.allPowerGeneration;
    }

    public void setAllPowerGeneration(Integer allPowerGeneration) {
      this.allPowerGeneration = allPowerGeneration;
    }

    public String getPid() {
      return this.pid;
    }

    public void setPid(String pid) {
      this.pid = pid;
    }

    public String getUnitProfit() {
      return this.unitProfit;
    }

    public void setUnitProfit(String unitProfit) {
      this.unitProfit = unitProfit;
    }

    public Double getUnitprice() {
      return this.unitprice;
    }

    public void setUnitprice(Double unitprice) {
      this.unitprice = unitprice;
    }

    public Integer getDeviceId() {
      return this.deviceId;
    }

    public void setDeviceId(Integer deviceId) {
      this.deviceId = deviceId;
    }

    public Integer getPlan_list_id() {
      return this.plan_list_id;
    }

    public void setPlan_list_id(Integer plan_list_id) {
      this.plan_list_id = plan_list_id;
    }

    public String getUid() {
      return this.uid;
    }

    public void setUid(String uid) {
      this.uid = uid;
    }

    public String getLoad() {
      return this.load;
    }

    public void setLoad(String load) {
      this.load = load;
    }

    public String getBalance() {
      return this.balance;
    }

    public void setBalance(String balance) {
      this.balance = balance;
    }

    public String getUsr() {
      return this.usr;
    }

    public void setUsr(String usr) {
      this.usr = usr;
    }

    public String getAlias() {
      return this.alias;
    }

    public void setAlias(String alias) {
      this.alias = alias;
    }

    public Object getName_solarapp() {
      return this.name_solarapp;
    }

    public void setName_solarapp(Object name_solarapp) {
      this.name_solarapp = name_solarapp;
    }

    public String getCurrency() {
      return this.currency;
    }

    public void setCurrency(String currency) {
      this.currency = currency;
    }

    public String getPlan_list_created() {
      return this.plan_list_created;
    }

    public void setPlan_list_created(String plan_list_created) {
      this.plan_list_created = plan_list_created;
    }

    public String getSn() {
      return this.sn;
    }

    public void setSn(String sn) {
      this.sn = sn;
    }

    public String getSignal() {
      return this.signal;
    }

    public void setSignal(String signal) {
      this.signal = signal;
    }

    public String getElectric_meter_type() {
      return this.electric_meter_type;
    }

    public void setElectric_meter_type(String electric_meter_type) {
      this.electric_meter_type = electric_meter_type;
    }

    public String getPname() {
      return this.pname;
    }

    public void setPname(String pname) {
      this.pname = pname;
    }

    public Object getModel_id() {
      return this.model_id;
    }

    public void setModel_id(Object model_id) {
      this.model_id = model_id;
    }

    public String getSellProfit() {
      return this.sellProfit;
    }

    public void setSellProfit(String sellProfit) {
      this.sellProfit = sellProfit;
    }

    public String getDevaddr() {
      return this.devaddr;
    }

    public void setDevaddr(String devaddr) {
      this.devaddr = devaddr;
    }

    public String getDevcode() {
      return this.devcode;
    }

    public void setDevcode(String devcode) {
      this.devcode = devcode;
    }

    public String getDescx() {
      return this.descx;
    }

    public void setDescx(String descx) {
      this.descx = descx;
    }

    public String getPn() {
      return this.pn;
    }

    public void setPn(String pn) {
      this.pn = pn;
    }

    public String getDid() {
      return this.did;
    }

    public void setDid(String did) {
      this.did = did;
    }

    public String getStatus() {
      return this.status;
    }

    public void setStatus(String status) {
      this.status = status;
    }
  }
}
