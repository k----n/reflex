package com.kalvineng.reflex.StatsPackage;

import com.kalvineng.reflex.ReactionPackage.ReactionStats;

import java.util.ArrayList;

/**
 Class to parse reaction data into meaningful data

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
