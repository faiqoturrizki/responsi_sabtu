package com.example.jean.retrofitexample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.adapter.DetailAdapter;
import com.example.jean.retrofitexample.model.History;
import com.example.jean.retrofitexample.model.HistoryItem;
import com.example.jean.retrofitexample.presenter.DetailPresenter;
import com.example.jean.retrofitexample.view.DetailView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity implements DetailView {
    DetailAdapter adapter;
    TextView namaPlayer,umur;
    ImageView fotoPLayer;
    // List<HistoryItem> historyItems =new ArrayList<>();
    int position;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        DetailPresenter detailPresenter = new DetailPresenter(this);
        detailPresenter.getHistory();


    }

    @Override
    public void updateDetail(List<History> histories) {
        Intent intent =getIntent();
        position=intent.getIntExtra("posisi",0);
        for (History history : histories){
            namaPlayer = findViewById(R.id.namaPlayerDetail);
            umur = findViewById(R.id.umur);
            fotoPLayer =findViewById(R.id.imgDetailPlayer);
            namaPlayer.setText("Nama :"+histories.get(position).getNama());
            umur.setText("Umur :"+histories.get(position).getAge());
            Picasso.with(this).load(histories.get(position).getGambar()).into(fotoPLayer);
            List<HistoryItem> historyItems = history.getHistory();
//            Log.d("histori", "updateDetail: "+historyItems.get(0).getKlub());
            adapter = new DetailAdapter(this,historyItems);
            adapter.setContext(DetailActivity.this);
            recyclerView=findViewById(R.id.rvHistory);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);
        }
    }
}
