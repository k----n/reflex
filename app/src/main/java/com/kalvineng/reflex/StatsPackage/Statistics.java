package com.kalvineng.reflex.StatsPackage;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kalvineng.reflex.R;
import com.kalvineng.reflex.ReactionPackage.ReactionStats;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Statistics extends ActionBarActivity {
    private StatsManager statsManager = new StatsManager();
    private StatsBuzzerParser statsBuzzerParser = new StatsBuzzerParser();
    private ReactionStatsCalc reactionStatsCalc = new ReactionStatsCalc();
    private  StatsReactionParser statsReactionParser = new StatsReactionParser();

    private static final String FILENAME0 = "stat_reaction.sav";
    private static final String FILENAME1 = "stat_buzzer.sav";

    protected ArrayList<String> reaction_records = new ArrayList<String>();
    protected ArrayList<String> buzzer_records = new ArrayList<String>();
    protected ArrayList<String> allStats;

    private ArrayAdapter<String> adapter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        // find listview
        listView = (ListView) findViewById(R.id.listView);

        loadingStats();

        // load stats into listview
        adapter = new ArrayAdapter<String>(this, R.layout.stats_list_item, allStats);

        // update listview
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_statistics, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_share) {
            // adapted from http://stackoverflow.com/q/8701634 08/01/15
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/html");
            intent.putExtra(Intent.EXTRA_SUBJECT, "My REFLEX Stats!");
            intent.putExtra(Intent.EXTRA_TEXT, stringBuilder(allStats));

            startActivity(Intent.createChooser(intent, "Send Email"));
        }

        if (id == R.id.item_delete){
            // adapated from http://stackoverflow.com/a/3554949
            File dir = getFilesDir();
            File file0 = new File(dir, FILENAME0);
            File file1 = new File(dir, FILENAME1);
            file0.delete();
            file1.delete();
            reaction_records.clear();
            buzzer_records.clear();
            adapter.clear();
            adapter.notifyDataSetChanged();
            loadingStats();
            adapter.addAll(allStats);
            adapter.notifyDataSetChanged();

        }

        return super.onOptionsItemSelected(item);
    }

    private void loadingStats(){
        // load stats
        ArrayList<Long> raw_reaction_records = statsManager.loadReactFile(getApplicationContext(), FILENAME0);
        ArrayList<Long> raw_reaction_records10 = statsReactionParser.getLast10Records(raw_reaction_records);
        ArrayList<Long> raw_reaction_records100 = statsReactionParser.getLast10Records(raw_reaction_records);
        ArrayList<String> raw_buzzer_records = statsManager.loadBuzzFile(getApplicationContext(), FILENAME1);


        // generate reaction stats
        parseReactionStats("All reaction", raw_reaction_records);
        parseReactionStats("Last 10 reaction", raw_reaction_records10);
        parseReactionStats("Last 100 reaction", raw_reaction_records100);

        // generate buzzer stats
        parseBuzzerStats(raw_buzzer_records);

        //combine both stats
        allStats = new ArrayList<String>(reaction_records);
        allStats.addAll(buzzer_records);
    }

    private void parseReactionStats(String last, ArrayList<Long> records){
        reaction_records.add(statsReactionParser.minTime(last, reactionStatsCalc.getMin(records)));
        reaction_records.add(statsReactionParser.maxTime(last, reactionStatsCalc.getMax(records)));
        reaction_records.add(statsReactionParser.avgTime(last, reactionStatsCalc.getAvg(records)));
        reaction_records.add(statsReactionParser.medianTime(last, reactionStatsCalc.getMedian(records)));

    }

    private void parseBuzzerStats(ArrayList<String> records){
        buzzer_records.add(statsBuzzerParser.countPlayer(2, 1, "2Players: 1 pressed", records));
        buzzer_records.add(statsBuzzerParser.countPlayer(2, 2, "2Players: 2 pressed", records));
        buzzer_records.add(statsBuzzerParser.countPlayer(3, 1, "3Players: 1 pressed", records));
        buzzer_records.add(statsBuzzerParser.countPlayer(3, 2, "3Players: 2 pressed", records));
        buzzer_records.add(statsBuzzerParser.countPlayer(3, 3, "3Players: 3 pressed", records));
        buzzer_records.add(statsBuzzerParser.countPlayer(4, 1, "4Players: 1 pressed", records));
        buzzer_records.add(statsBuzzerParser.countPlayer(4, 2, "4Players: 2 pressed", records));
        buzzer_records.add(statsBuzzerParser.countPlayer(4, 3, "4Players: 3 pressed", records));
        buzzer_records.add(statsBuzzerParser.countPlayer(4, 4, "4Players: 4 pressed", records));
    }

    private String stringBuilder(ArrayList<String> records){
        String string = new String();
        for (int i = 0; i < records.size(); ++i){
            string+=records.get(i);
        }
        return string;
    }

}
