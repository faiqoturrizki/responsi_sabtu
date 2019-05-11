package com.example.jean.retrofitexample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.activity.DetailActivity;
import com.example.jean.retrofitexample.model.HistoryItem;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder>{
    List<HistoryItem> historyItems;
    Context context;

    public DetailAdapter(DetailActivity detailActivity, List<HistoryItem> historyItems) {
        this.historyItems = historyItems;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HistoryItem historyItem = historyItems.get(position);
        holder.playerHistory.setText(String.valueOf(historyItems.get(position).getKlub()));
    }

    @Override
    public int getItemCount() {
        if (historyItems!=null){
            return historyItems.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView playerHistory;
        public ViewHolder(View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            playerHistory=itemView.findViewById(R.id.tvHistory);
        }
    }
}
