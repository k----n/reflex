package com.kalvineng.reflex.StatsPackage;

import java.util.ArrayList;
import java.util.Collections;

/**
 Class to calculate Reaction Time Stats (min, max, avg, median)

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
