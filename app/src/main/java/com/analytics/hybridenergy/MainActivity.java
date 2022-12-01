package com.analytics.hybridenergy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.analytics.hybridenergy.adapter.SataionAdapter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    String jsonData = "{\n" +
            "    \"code\": \"000\",\n" +
            "    \"msg\": \"success\",\n" +
            "    \"success\": true,\n" +
            "    \"requestId\": \"xxxxxx\",\n" +
            "    \"total\": 0,\n" +
            "    \"total_hybridpro\": 3,\n" +
            "    \"total_renac\": 0,\n" +
            "    \"stationList\": [],\n" +
            "    \"stationList_hybridpro\": [\n" +
            "        {\n" +
            "            \"plan_list_id\": 204,\n" +
            "            \"alias\": \"HybridProRam\",\n" +
            "            \"name_solarapp\": null,\n" +
            "            \"pn\": \"Q0025397171739\",\n" +
            "            \"descx\": \"Wi-Fi Plug Pro\",\n" +
            "            \"status\": \"1\",\n" +
            "            \"fireware\": \"3.4.1.1\",\n" +
            "            \"pid\": \"3030476\",\n" +
            "            \"pname\": \"MYBMSPLANT\",\n" +
            "            \"signal\": \"0\",\n" +
            "            \"load\": \"1\",\n" +
            "            \"balance\": \"0\",\n" +
            "            \"usr\": \"psihybridenergy\",\n" +
            "            \"uid\": \"4090899\",\n" +
            "            \"did\": \"0\",\n" +
            "            \"unitProfit\": \"4.7\",\n" +
            "            \"currency\": \"฿\",\n" +
            "            \"buyProfit\": \"4.7\",\n" +
            "            \"sellProfit\": \"4.7\",\n" +
            "            \"electric_meter_type\": \"ประเภทบ้านพักอาศัย\",\n" +
            "            \"unitprice\": 4.3,\n" +
            "            \"model_id\": null,\n" +
            "            \"allPowerGeneration\": 0,\n" +
            "            \"plan_list_created\": \"2022-10-27 15:43:27.000\",\n" +
            "            \"deviceId\": 1,\n" +
            "            \"devcode\": \"2341\",\n" +
            "            \"devaddr\": \"5\",\n" +
            "            \"sn\": \"Q0025397171739092505\",\n" +
            "            \"timezone\": \"25200\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"plan_list_id\": 205,\n" +
            "            \"alias\": \"6.2\",\n" +
            "            \"name_solarapp\": null,\n" +
            "            \"pn\": \"Q0025397183514\",\n" +
            "            \"descx\": \"Wi-Fi Plug Pro\",\n" +
            "            \"status\": \"0\",\n" +
            "            \"fireware\": \"3.4.1.1\",\n" +
            "            \"pid\": \"3030476\",\n" +
            "            \"pname\": \"MYBMSPLANT\",\n" +
            "            \"signal\": \"100\",\n" +
            "            \"load\": \"1\",\n" +
            "            \"balance\": \"0\",\n" +
            "            \"usr\": \"psihybridenergy\",\n" +
            "            \"uid\": \"4090899\",\n" +
            "            \"did\": \"0\",\n" +
            "            \"unitProfit\": \"4.7\",\n" +
            "            \"currency\": \"฿\",\n" +
            "            \"buyProfit\": \"4.7\",\n" +
            "            \"sellProfit\": \"4.7\",\n" +
            "            \"electric_meter_type\": \"ประเภทบ้านพักอาศัย\",\n" +
            "            \"unitprice\": 4.3,\n" +
            "            \"model_id\": null,\n" +
            "            \"allPowerGeneration\": 0,\n" +
            "            \"plan_list_created\": \"2022-10-27 15:43:27.000\",\n" +
            "            \"deviceId\": 2,\n" +
            "            \"devcode\": \"2341\",\n" +
            "            \"devaddr\": \"5\",\n" +
            "            \"sn\": \"Q0025397183514092505\",\n" +
            "            \"timezone\": \"25200\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"plan_list_id\": 206,\n" +
            "            \"alias\": \"New module wifi\",\n" +
            "            \"name_solarapp\": null,\n" +
            "            \"pn\": \"Q01380220100748448\",\n" +
            "            \"descx\": \"Wi-Fi Plug Pro\",\n" +
            "            \"status\": \"0\",\n" +
            "            \"fireware\": \"3.94.1.1\",\n" +
            "            \"pid\": \"3030476\",\n" +
            "            \"pname\": \"MYBMSPLANT\",\n" +
            "            \"signal\": \"100\",\n" +
            "            \"load\": \"1\",\n" +
            "            \"balance\": \"0\",\n" +
            "            \"usr\": \"psihybridenergy\",\n" +
            "            \"uid\": \"4090899\",\n" +
            "            \"did\": \"0\",\n" +
            "            \"unitProfit\": \"4.7\",\n" +
            "            \"currency\": \"฿\",\n" +
            "            \"buyProfit\": \"4.7\",\n" +
            "            \"sellProfit\": \"4.7\",\n" +
            "            \"electric_meter_type\": \"ประเภทบ้านพักอาศัย\",\n" +
            "            \"unitprice\": 4.3,\n" +
            "            \"model_id\": null,\n" +
            "            \"allPowerGeneration\": 0,\n" +
            "            \"plan_list_created\": \"2022-11-23 11:11:21.000\",\n" +
            "            \"deviceId\": 3,\n" +
            "            \"devcode\": \"2341\",\n" +
            "            \"devaddr\": \"5\",\n" +
            "            \"sn\": \"Q01380220100748448092505\",\n" +
            "            \"timezone\": \"25200\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"stationList_renac\": [],\n" +
            "    \"hybridpro_token\": \"8e5c2502ce086022d5785d0283a71bf5b61bd9ae7e00fdc090fd6ccd62765c8b\",\n" +
            "    \"hybridpro_secret\": \"1cc2861b5ed6f4b8afcedfd3fd1aff6ba474e019\"\n" +
            "}";

    public void onDestroy() {
        // Dialog_dismiss();
        super.onDestroy();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list);
        recyclerView = (RecyclerView) findViewById(R.id.rv_data);

        initControls();

    }

    private void initControls() {
        Gson gson = new Gson();
        SataionModel data = gson.fromJson(this.jsonData, SataionModel.class);
        List<SataionModel.StationList_hybridpro>  stationList = (List<SataionModel.StationList_hybridpro>) data.getStationList_hybridpro();


        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SataionAdapter modelAdapter = new SataionAdapter(this, stationList);
        recyclerView.setAdapter(modelAdapter);
        recyclerView.refreshDrawableState();
        modelAdapter.setOnItemClickListener(new SataionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Intent i = new Intent(getApplicationContext(),QueryDeviceLastDataActivity.class);
                i.putExtra("pn",stationList.get(position).getPn());
                i.putExtra("devcode",stationList.get(position).getDevcode());
                i.putExtra("devaddr",stationList.get(position).getDevaddr());
                i.putExtra("sn",stationList.get(position).getSn());
                i.putExtra("hybridpro_token",data.getHybridpro_token());
                i.putExtra("hybridpro_secret",data.getHybridpro_secret());
                startActivity(i);



            }
        });

    }

}