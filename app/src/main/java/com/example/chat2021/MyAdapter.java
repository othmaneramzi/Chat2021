package com.example.chat2021;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder> {

    ArrayList<Conversation> list;
    Context context;
    String hash;

    private static RecycleViewer rv;
    private static final String CAT = "LE4-SI";
    public MyAdapter(ArrayList<Conversation> list, Context context, RecycleViewer rv) {
        this.list = list;
        this.context = context;
        this.rv = rv;
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.my_row,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.nomConv.setText(list.get(position).getTheme());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            TextView nomConv ;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            nomConv = itemView.findViewById(R.id.mesconv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            rv.recyclerViewListClicked(MyAdapter.this.list.get(this.getLayoutPosition()));
        }
    }
}
