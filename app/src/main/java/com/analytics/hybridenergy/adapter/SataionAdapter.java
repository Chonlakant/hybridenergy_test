/**
 * @file MovieAdapter.java
 * @brief This is an adapter class responsible for showing movies data.
 * @author Shrikant
 * @date 14/04/2018
 */
package com.analytics.hybridenergy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.analytics.hybridenergy.R;
import com.analytics.hybridenergy.SataionModel;

import java.util.List;


public class SataionAdapter extends RecyclerView.Adapter<SataionAdapter.MyViewHolder> {

    private Context context;
    private List<SataionModel.StationList_hybridpro> categoryItems;

    private String fromDate;
    private String toDate;

    private OnItemClickListener onItemClickListener;

    public SataionAdapter(Context context, List<SataionModel.StationList_hybridpro> categoryItems) {
        this.context = context;
        this.categoryItems = categoryItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_dltv_item, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        SataionModel.StationList_hybridpro item = categoryItems.get(position);

        holder.txt_title.setText(item.getAlias());
        holder.txt_desc.setText(item.getDescx());


    }

    @Override
    public int getItemCount() {
        return categoryItems.size();
    }


    public void setFilterParameter(String fromDate, String toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt_title,txt_desc;


        LinearLayout ls_onclick;


        public MyViewHolder(View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_desc = itemView.findViewById(R.id.txt_desc);

            ls_onclick = itemView.findViewById(R.id.ls_onclick);

            ls_onclick.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ls_onclick:
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(getAdapterPosition());
                    }
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    //for handing long click and simple click on an item
    public interface OnItemClickListener {
        void onItemClick(int position);
    }


}
