package com.analytics.hybridenergy;

import com.analytics.hybridenergy.model.ParamModel;
import com.analytics.hybridenergy.model.info.InfoDataModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/public/?")
    Call<InfoDataModel> oneDayInfomation(
             @Query("sign") String sign
            , @Query("salt") String salt
            , @Query("token") String token
            , @Query("action") String action
            , @Query("source") String source
            , @Query("app_id") String app_id
            , @Query("app_version") String app_version
            , @Query("app_client") String app_client
            , @Query("i18n") String i18n
            , @Query("pn") String pn
            , @Query("devcode") String devcode
            , @Query("devaddr") String devaddr
            , @Query("sn") String sn
            , @Query("parameter") String parameter
            , @Query("date") String date
    );
    @GET("/public/?")
    Call<ParamModel> getParam(
            @Query("sign") String sign
            , @Query("salt") String salt
            , @Query("token") String token
            , @Query("action") String action
            , @Query("source") String source
            , @Query("app_id") String app_id
            , @Query("app_version") String app_version
            , @Query("app_client") String app_client
            , @Query("devcode") String devcode
    );
    @GET("/public/?")
    Call<Object> getLastData(
            @Query("sign") String sign
            , @Query("salt") String salt
            , @Query("token") String token
            , @Query("action") String action
            , @Query("source") String source
            , @Query("app_id") String app_id
            , @Query("app_version") String app_version
            , @Query("app_client") String app_client
            , @Query("pn") String pn
            , @Query("devcode") String devcode
            , @Query("devaddr") String devaddr
            , @Query("sn") String sn
            , @Query("date") String date
    );

}