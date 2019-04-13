package com.example.jean.retrofitexample.view;

import com.example.jean.retrofitexample.model.History;
import com.example.jean.retrofitexample.player.Player;

import java.util.List;

public interface FootballView {

    void playerFootball(List<Player> players);
    void historyReady(List<History> histories);
}
