package com.kalvineng.reflex.ReactionPackage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kalvineng.reflex.R;
import com.kalvineng.reflex.StatsPackage.StatsManager;

import java.util.ArrayList;

/**
 Activity Class that creates Reaction Times UI interface

 Calls classes within ReactionPackage and StatsManager


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

public class ReactionTimes extends ActionBarActivity {
    private Handler handler;
    private Runnable start, restart;

    // initialize game instance
    private ReactionWatch instanceTimer = new ReactionWatch();
    private ReactionStats reactionStats = new ReactionStats();

    // initialize record keeping
    private static final String FILENAME = "stat_reaction.sav";
    private StatsManager statsManager = new StatsManager();
    private ArrayList<Long> records;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_times);

        // load stats
        records = statsManager.loadReactFile(getApplicationContext(), FILENAME);
        reactionStats.setRecords(records);

        // start game
        instanceTimer.start();

        final RelativeLayout rlayout = (RelativeLayout) findViewById(R.id.startlayout);
        final TextView textView = (TextView) findViewById(R.id.reactionText);
        handler = new Handler();

        start = new Runnable() {

            @Override
            public void run() {
                rlayout.setBackgroundColor(Color.argb(255, 102, 187, 106));
                textView.setText("Go!");
                // textView.setText("Go!" + String.valueOf(instanceTimer.getRandomTime()));
            }
        };

        restart = new Runnable() {

            @Override
            public void run() {
                // taken from http://stackoverflow.com/a/3974828 08/01/15
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        };

        handler.postDelayed(start, instanceTimer.getRandomTime());

        rlayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                handler.removeCallbacks(start); //do not run start again

                if (!instanceTimer.check()) {
                    rlayout.setEnabled(false); // prevent touch
                    rlayout.setBackgroundColor(Color.argb(255, 75, 195, 247));
                    textView.setText("You must wait for green ;)");
                    instanceTimer.reset(); // reset game
                    handler.postDelayed(restart, 2500);

                } else {
                    rlayout.setEnabled(false); // prevent touch
                    TextView textView = (TextView) findViewById(R.id.reactionText);
                    long reactionTime = instanceTimer.getReactionTime();
                    textView.setText("Your time was " + String.valueOf(reactionTime) + "ms");
                    instanceTimer.reset(); // reset game
                    reactionStats.addRecord(reactionTime); // record time
                    statsManager.saveReactStat(getApplicationContext(), FILENAME, reactionStats.getRecords());
                    handler.postDelayed(restart, 2500);
                }
            }
        });

    }

    @Override
    protected void onPause() {
        handler.removeCallbacksAndMessages(null);
        super.onPause();
    }

    @Override
    protected void onStop() {
        handler.removeCallbacksAndMessages(null);
        super.onStop();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

}
