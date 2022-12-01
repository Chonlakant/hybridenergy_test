package com.analytics.hybridenergy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.security.MessageDigest;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuerySPDeviceLastDataActivity extends AppCompatActivity {

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
        hybridpro_token = getIntent().getStringExtra("hybridpro_token");
        hybridpro_secret = getIntent().getStringExtra("hybridpro_secret");

        Log.e("SHA1_44444", pn);
        Log.e("SHA1_44444", devcode);
        Log.e("SHA1_44444", devaddr);
        Log.e("SHA1_44444", sn);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Secret = hybridpro_secret;
                String Token = hybridpro_token;

                String sing = SHA1(salt + Secret + Token + "&action=querySPDeviceLastData&source=1&app_id=com.softtechnetwork.PSI-Hybrid-Energy&app_version=1&app_client=web&pn="+pn+"&devcode="+devcode+"&devaddr="+devaddr+"&sn="+sn+"&date="+"2022-09-21");
                Log.e("sing_1111", sing);
                //834ba22dc947c0d19b17e7a1b9ff1f3870ccae67

                //&action=querySPDeviceLastData&source=1&app_id=com.softtechnetwork.PSI-Hybrid-Energy&app_version=1&app_client=web&pn=Q01380220100748448&devcode=2341&devaddr=5&sn=Q01380220100748448092505&date=2022-09-21

                Call<Object> call = apiInterface.getLastData(
                        sing
                        , salt
                        , Token
                        , "querySPDeviceLastData"
                        , "1"
                        , "com.softtechnetwork.PSI-Hybrid-Energy"
                        , "1"
                        , "web"
                        , pn
                        , devcode
                        , devaddr
                        , sn
                        , "2022-09-21");
                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {

                        Gson gson = new Gson();
                        Log.e("hhhhhhhhh", gson.toJson(response));
                        Log.e("hhhhhhhhh", gson.toJson(response.code() +""));
                        txt_show.setText("");
                        txt_show.setText(gson.toJson(response.code()+" : "+gson.toJson(response)));

                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Log.e("hhhhhhhhh", t.getLocalizedMessage());
                    }
                });
            }
        });
    }



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