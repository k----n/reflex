package com.kalvineng.reflex.BuzzerPackage;

import java.util.ArrayList;

/**
 * Created by Kalvin on 2015-10-01.
 */
public class BuzzerStats {
    private ArrayList<String> records = new ArrayList<String>();
    private int amountPlayers;
    private int currentPlayer;

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setAmountPlayers(int amountPlayers) {
        this.amountPlayers = amountPlayers;
    }

    public ArrayList<String> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<String> records) {
        this.records = records;
    }

    public void addRecord(){
        records.add(Integer.toString(amountPlayers) + "Players: " + Integer.toString(currentPlayer) +" pressed" );
    }
}
