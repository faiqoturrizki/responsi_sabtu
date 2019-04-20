package com.example.jean.retrofitexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.model.History;
import com.example.jean.retrofitexample.view.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    List<History> historyList;
    Context context;

    public MainAdapter(MainActivity mainActivity, List<History> historyList) {
        this.historyList = historyList;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemplayer,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        History history = historyList.get(position);
        holder.playerName.setText(String.valueOf(historyList.get(position).getNama()));
        holder.usia.setText("Usia :"+String.valueOf(historyList.get(position).getAge()));

        Picasso.with(context).load(historyList.get(position).getGambar()).into(holder.playerImage);
    }

    @Override
    public int getItemCount() {
        if (historyList!=null){
            return historyList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView playerImage;
        TextView playerName,usia;
        public ViewHolder(View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            playerImage=itemView.findViewById(R.id.imgPlayer);
            playerName = itemView.findViewById(R.id.tvPlayer);
            usia = itemView.findViewById(R.id.tvusia);
        }
    }
}
