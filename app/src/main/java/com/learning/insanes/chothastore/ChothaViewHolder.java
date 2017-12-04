package com.learning.insanes.chothastore;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class ChothaViewHolder extends RecyclerView.ViewHolder {
    TextView name, subtitle;
    public ChothaViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.chotha_view_name);
        subtitle = itemView.findViewById(R.id.chotha_view_link);
    }
}
