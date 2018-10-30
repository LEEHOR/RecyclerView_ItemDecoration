package com.example.test.recycleviewstickyheader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Leehor
 * on 2018/10/29
 * on 15:10
 */
public class RecyclerView_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Bean> list;
    public RecyclerView_adapter(Context context) {
        this.context = context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<Bean> list){
        this.list=list;
        getItemCount();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CityHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item, viewGroup, false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof CityHolder){
            ((CityHolder)viewHolder).tv_city.setText(list.get(i).getCity_name());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class CityHolder extends RecyclerView.ViewHolder{
        private TextView tv_city;
        public CityHolder(@NonNull View itemView) {
            super(itemView);
            tv_city= itemView.findViewById(R.id.tv_city);
        }

    }
}
