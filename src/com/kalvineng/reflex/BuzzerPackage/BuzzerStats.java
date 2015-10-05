package com.kalvineng.reflex.BuzzerPackage;

import java.util.ArrayList;

/**
 Class for Managing Buzzer Stats

 Copyright 2015 Kalvin Eng

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 **/
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
