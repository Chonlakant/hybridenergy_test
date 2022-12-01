package com.analytics.hybridenergy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.analytics.hybridenergy.model.info.InfoDataModel;
import com.google.gson.Gson;

import java.security.MessageDigest;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OneDayInfomation extends AppCompatActivity {
    int selectedYear = 2022;
    int selectedMonth = 11;
    int selectedDayOfMonth = 28;

    Button btn_show;
    TextView txt_show;
    APIInterface apiInterface;
    
    String salt = "16637343372264";
    String pn;
    String devcode;
    String devaddr;
    String sn;
    String hybridpro_token;
    String hybridpro_secret;
    String parameter_pv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_show = findViewById(R.id.btn_show);
        txt_show = findViewById(R.id.txt_show);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        pn =  getIntent().getStringExtra("pn");
        devcode = getIntent().getStringExtra("devcode");
        devaddr = getIntent().getStringExtra("devaddr");
        sn = getIntent().getStringExtra("sn");
        parameter_pv = getIntent().getStringExtra("parameter_pv");
        hybridpro_token = getIntent().getStringExtra("hybridpro_token");
        hybridpro_secret = getIntent().getStringExtra("hybridpro_secret");

        Log.e("log_data->>", pn);
        Log.e("log_data->>", devcode);
        Log.e("log_data->>", devaddr);
        Log.e("log_data->>", sn);
        Log.e("log_data->>", parameter_pv);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show
                DatePickerDialog datePickerDialog = new DatePickerDialog(OneDayInfomation.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar, dateSetListener, selectedYear, selectedMonth, selectedDayOfMonth);
                datePickerDialog.show();
            }
        });
    }

    // Date Select Listener.
    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            Log.e("date_time", year + ": " + monthOfYear + "" + dayOfMonth);
            String Secret = hybridpro_secret;
            String Token = hybridpro_token;
            String day = year+"-"+monthOfYear+"-"+dayOfMonth;

            String sing = SHA1(salt + Secret + Token + "&action=querySPDeviceKeyParameterOneDay&source=1&app_id=com.softtechnetwork.PSI-Hybrid-Energy&app_version=1&app_client=ios&i18n=en_US&pn="+pn+"&devcode="+devcode+"&devaddr="+devaddr+"&sn="+sn+"&parameter="+parameter_pv+"&date="+day);
            Log.e("sing_", sing);

            Call<InfoDataModel> call = apiInterface.oneDayInfomation(
                    sing
                    , salt
                    , Token
                    , "querySPDeviceKeyParameterOneDay"
                    , "1"
                    , "com.softtechnetwork.PSI-Hybrid-Energy"
                    , "1"
                    , "ios"
                    , "en_US"
                    , pn
                    , devcode
                    , devaddr
                    , sn
                    , parameter_pv
                    , day);
            call.enqueue(new Callback<InfoDataModel>() {
                @Override
                public void onResponse(Call<InfoDataModel> call, Response<InfoDataModel> response) {

                    Gson gson = new Gson();
                 //   Log.e("json_data", gson.toJson(response));
                    Log.e("json_data", gson.toJson(response.body().getDat()));
                    //    Log.e("json_data", gson.toJson(response.code() +""));
                    txt_show.setText("");
                    txt_show.setText(gson.toJson(response.code()+" : "+gson.toJson(response)));

                }

                @Override
                public void onFailure(Call<InfoDataModel> call, Throwable t) {
                    Log.e("error_data", t.getLocalizedMessage());
                }
            });
        }
    };


    public static String byteArrayToString(byte[] bytes) {
        StringBuilder buffer = new StringBuilder();
        for (byte b : bytes) {
            buffer.append(String.format(Locale.getDefault(), "%02x", b));
        }
        return buffer.toString();
    }

    public static String SHA1(String clearString) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(clearString.getBytes("UTF-8"));
            return byteArrayToString(messageDigest.digest());
        } catch (Exception ignored) {
            ignored.printStackTrace();
            return null;
        }
    }
}