package com.example.jean.retrofitexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.model.History;
import com.example.jean.retrofitexample.player.Player;
import com.example.jean.retrofitexample.presenter.FootballPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FootballView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FootballPresenter footballPresenter = new FootballPresenter(this);

        // Maybe it's best to call it on onResume()
        footballPresenter.getPlayerPresenter();
        footballPresenter.getHistory();
    }

    @Override
    public void playerFootball(List<Player> players) {

        // See your Logcat :)
        for (Player player : players) {
            Log.i("RETROFIT", player.getNama() + "\n"
                    + " - Alpha2:  " + player.getNegara() + " \n"
                    + " - Alpha3: " + player.getTeam());
        }
    }

    public void historyReady(List<History> histories) {
        for (History history : histories) {
            Log.d("RETROFIT", "historyReady: " + "\n"
                    + "NAMA :" + history.getNama() + "\n"
                    + "Deskripsi :" + history.getDeskripsi());
        }
    }

}
