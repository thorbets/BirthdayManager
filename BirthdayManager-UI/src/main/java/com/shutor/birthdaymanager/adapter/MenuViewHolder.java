package com.shutor.birthdaymanager.adapter;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shutor.birthdaymanager.R;

public class MenuViewHolder extends RecyclerView.ViewHolder {

    public View container;
    public AppCompatImageView image;
    public TextView title;

    public MenuViewHolder(View itemView) {
        super(itemView);
        container = itemView.findViewById(R.id.item_list_menu_container);
        image = (AppCompatImageView) itemView.findViewById(R.id.item_list_menu_image);
        title = (TextView) itemView.findViewById(R.id.item_list_menu_title);
    }
}
