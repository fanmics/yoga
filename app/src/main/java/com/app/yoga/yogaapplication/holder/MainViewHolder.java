package com.app.yoga.yogaapplication.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.yoga.yogaapplication.R;

/**
 * Created by Lenovo on 5/9/2016.
 */
public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView cardName;
    public ImageView cardPhoto;

    public MainViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        cardName = (TextView) itemView.findViewById(R.id.card_name);
        cardPhoto = (ImageView) itemView.findViewById(R.id.card_photo);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(),"Clicked Country Position = " + getPosition(),Toast.LENGTH_SHORT).show();
    }
}
