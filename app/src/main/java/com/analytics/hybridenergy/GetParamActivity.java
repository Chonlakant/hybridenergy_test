package com.analytics.hybridenergy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.analytics.hybridenergy.model.ParamModel;
import com.google.gson.Gson;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetParamActivity extends AppCompatActivity {

    APIInterface apiInterface;
    
    String salt = "16637343372264";
    String pn;
    String devcode;
    String devaddr;
    String sn;
    String hybridpro_token;
    String hybridpro_secret;

    List<String> listData = new ArrayList<>();

    private Spinner spinner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_param);
        spinner = findViewById(R.id.spinner);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        pn =  getIntent().getStringExtra("pn");
        devcode = getIntent().getStringExtra("devcode");
        devaddr = getIntent().getStringExtra("devaddr");
        sn = getIntent().getStringExtra("sn");
        hybridpro_token = getIntent().getStringExtra("hybridpro_token");
        hybridpro_secret = getIntent().getStringExtra("hybridpro_secret");

        Log.e("log_data->>", pn);
        Log.e("log_data->>", devcode);
        Log.e("log_data->>", devaddr);
        Log.e("log_data->>", sn);

        String sing = SHA1(salt + hybridpro_secret + hybridpro_token + "&action=querySPKeyParameters&source=1&app_id=com.softtechnetwork.PSI-Hybrid-Energy&app_version=1&app_client=ios&devcode="+devcode);
        Log.e("sing_", sing);
        Call<ParamModel> call = apiInterface.getParam(
                sing
                , salt
                , hybridpro_token
                , "querySPKeyParameters"
                , "1"
                , "com.softtechnetwork.PSI-Hybrid-Energy"
                , "1"
                , "ios"
                , devcode);
        call.enqueue(new Callback<ParamModel>() {
            @Override
            public void onResponse(Call<ParamModel> call, Response<ParamModel> response) {

                Gson gson = new Gson();

                listData.add("กรุณาเลือก");
                for(int i= 0; i < response.body().getDat().getKeys().size();i++){
                    listData.add(response.body().getDat().getKeys().get(i).toString());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_item, listData);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        if(position != 0){
                            Intent  i = new Intent(getApplicationContext(),OneDayInfomation.class);
                            i.putExtra("pn",pn);
                            i.putExtra("devcode",devcode);
                            i.putExtra("devaddr",devaddr);
                            i.putExtra("sn",sn);
                            i.putExtra("hybridpro_token",hybridpro_token);
                            i.putExtra("hybridpro_secret",hybridpro_secret);
                            i.putExtra("parameter_pv",listData.get(position).toString());
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                Log.e("json_data", gson.toJson(response.body()));
                Log.e("json_data", gson.toJson(response.code() +""));

            }

            @Override
            public void onFailure(Call<ParamModel> call, Throwable t) {

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