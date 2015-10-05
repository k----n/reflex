package com.kalvineng.reflex.ReactionPackage;

import com.kalvineng.reflex.StatsPackage.StatsManager;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kalvin on 2015-10-03.
 */
public class ReactionStats {

    private ArrayList<Long> records;

    public ArrayList<Long> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Long> records) {
        this.records = records;
    }

    public void addRecord(long time){
        records.add(time);
    }

}
