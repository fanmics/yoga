package com.app.yoga.yogaapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.yoga.yogaapplication.R;
import com.app.yoga.yogaapplication.holder.MainViewHolder;
import com.app.yoga.yogaapplication.objects.MainItemObject;

import java.util.List;

/**
 * Created by Lenovo on 5/9/2016.
 */
public class MainViewAdapter extends RecyclerView.Adapter<MainViewHolder> {


    private List<MainItemObject> itemList;
    private Context context;

    public MainViewAdapter(Context context, List<MainItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_card_list,null);
        MainViewHolder rcv = new MainViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
    holder.cardName.setText(itemList.get(position).getName());
    holder.cardPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
