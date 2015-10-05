package com.kalvineng.reflex.StatsPackage;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kalvin on 2015-10-05.
 */
public class ReactionStatsCalc {

    public long getMin(ArrayList<Long> records){
        if (!records.isEmpty()) {
            return Collections.min(records);
        }
        else {
            return 0;
        }

    }

    public long getMax(ArrayList<Long> records){
        if (!records.isEmpty()) {
            return Collections.max(records);
        }
        else {
            return 0;
        }
    }

    public double getAvg(ArrayList<Long> records){
        double sum = 0;
        if (!records.isEmpty()){
            for (int i = 0; i < records.size(); ++i){
                sum+= records.get(i);
            }
        }
        else {
            return 0;
        }
        return sum / records.size();
    }

    // adapted from http://stackoverflow.com/a/4191729 08/01/15
    public long getMedian(ArrayList<Long> records){
        long median = 0;

        if (!records.isEmpty()) {
            Collections.sort(records);

            if (records.size() % 2 == 1) {
                median = records.get(((records.size() + 1) / 2) - 1);
            }

            else
            {
                long lower = records.get((records.size()/2) - 1);
                long upper = records.get(records.size()/2);
                median = (lower + upper)/2;
            }
        }
        else {
            return 0;
        }

        return median;
    }

}
