package com.kalvineng.reflex.BuzzerPackage;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.kalvineng.reflex.R;
import com.kalvineng.reflex.StatsPackage.StatsManager;

import java.util.ArrayList;

/**
 Activity Class that creates buzzer UI interface using fragments

 Calls other classes within BuzzerPackage and StatsManager

 Copyright 2015 Google Inc, Kalvin Eng

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
public class Buzzer extends ActionBarActivity {
    private BuzzerStats buzzerGame = new BuzzerStats();

    // initialize record keeping
    private static final String FILENAME = "stat_buzzer.sav";
    private StatsManager statsManager = new StatsManager();
    private ArrayList<String> records;

    // define player modes
    private Fragment twoPlayer = new BuzzerFragment2();
    private Fragment threePlayer = new BuzzerFragment3();
    private Fragment fourPlayer = new BuzzerFragment4();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzzer);

        int mode = getIntent().getIntExtra("amount",0); //get player amount from MainMenu
        buzzerGame.setAmountPlayers(mode + 2); // add 2 to get actual amount of players

        loadStats();

        // initialize fragment activity
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // select mode based on dialog selection
        switch(mode){
            case 0:
                transaction.replace(R.id.buzzer_container, twoPlayer);
                transaction.addToBackStack(null);
                break;

            case 1:
                transaction.replace(R.id.buzzer_container, threePlayer);
                transaction.addToBackStack(null);
                break;

            case 2:
                transaction.replace(R.id.buzzer_container, fourPlayer);
                transaction.addToBackStack(null);
                break;

        }
        transaction.commit();

    }

    public void player1(View view) {
        Bundle args = new Bundle();
        args.putString("message", "Player 1 pressed!");
        DialogFragment buzzerDialog = new BuzzerPressDialog();
        buzzerDialog.setArguments(args);
        buzzerDialog.show(getFragmentManager(), "Player1Buzz");
        buzzerDialog.setCancelable(false);
        saveStats(1);
    }

    public void player2(View view) {
        Bundle args = new Bundle();
        args.putString("message", "Player 2 pressed!");
        DialogFragment buzzerDialog = new BuzzerPressDialog();
        buzzerDialog.setArguments(args);
        buzzerDialog.show(getFragmentManager(), "Player2Buzz");
        buzzerDialog.setCancelable(false);
        saveStats(2);
    }

    public void player3(View view) {
        Bundle args = new Bundle();
        args.putString("message", "Player 3 pressed!");
        DialogFragment buzzerDialog = new BuzzerPressDialog();
        buzzerDialog.setArguments(args);
        buzzerDialog.show(getFragmentManager(), "Player3Buzz");
        buzzerDialog.setCancelable(false);
        saveStats(3);
    }

    public void player4(View view) {
        Bundle args = new Bundle();
        args.putString("message", "Player 4 pressed!");
        DialogFragment buzzerDialog = new BuzzerPressDialog();
        buzzerDialog.setArguments(args);
        buzzerDialog.show(getFragmentManager(), "Player4Buzz");
        buzzerDialog.setCancelable(false);
        saveStats(4);
    }

    private void loadStats(){
        records = statsManager.loadBuzzFile(getApplicationContext(), FILENAME);
        buzzerGame.setRecords(records);
    }

    private void saveStats(int player){
        buzzerGame.setCurrentPlayer(player);
        buzzerGame.addRecord(); // record press
        statsManager.saveBuzzStat(getApplicationContext(), FILENAME, buzzerGame.getRecords());
    }

}
