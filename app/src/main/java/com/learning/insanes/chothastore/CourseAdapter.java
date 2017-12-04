package com.learning.insanes.chothastore;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CourseAdapter extends RecyclerView.Adapter<ChothaViewHolder> {

    Cursor cursor;

    public CourseAdapter(Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public ChothaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChothaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chotha_view,parent, false));
    }

    @Override
    public void onBindViewHolder(final ChothaViewHolder holder, int position) {
        if(cursor.moveToPosition(position)) {
            holder.name.setText(cursor.getString(0));
            holder.subtitle.setText(cursor.getString(1));
            final Integer pos = position;
            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(holder.name.getContext(), ChothaListActivity.class);
                    intent.putExtra("coursename", cursor.getString(0));
                    holder.name.getContext().startActivity(intent);
                }
            };
            holder.name.setOnClickListener(listener);
            holder.subtitle.setOnClickListener(listener);
        }
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }
}
