package com.kalvineng.reflex.StatsPackage;

import com.kalvineng.reflex.ReactionPackage.ReactionStats;

import java.util.ArrayList;

/**
 * Created by Kalvin on 2015-10-04.
 */
public class StatsReactionParser {

    public ArrayList<Long> getLast10Records(ArrayList<Long> records){
        // adapted from http://stackoverflow.com/a/14606059 08/01/15
        return new ArrayList<Long>(records.subList(Math.max(records.size()-10,0),records.size()));
    }

    public ArrayList<Long> getLast100Records(ArrayList<Long> records){
        // adapted from http://stackoverflow.com/a/14606059 08/01/15
        return new ArrayList<Long>(records.subList(Math.max(records.size()-100,0),records.size()));
    }

    public String minTime(String lastTime, long min){
        if (min == 0){
            return lastTime + " times min: Not Available \n";
        }
        return lastTime + " times min: " + Long.toString(min) + "\n";
    }

    public String maxTime(String lastTime, long max){
        if (max == 0){
            return lastTime + " times max: Not Available \n";
        }
        return lastTime + " times max: " + Long.toString(max) + "\n";
    }

    public String avgTime(String lastTime, double avg){
        if (avg == 0){
            return lastTime + " times average: Not Available \n";
        }
        return lastTime + " times average: " + Double.toString(avg) + "\n";
    }

    public String medianTime(String lastTime, long median){
        if (median == 0){
            return lastTime + " times median: Not Available \n";
        }
        return lastTime + " times median: " + Double.toString(median) + "\n";
    }

}
