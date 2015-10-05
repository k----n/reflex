package com.kalvineng.reflex.ReactionPackage;

import com.kalvineng.reflex.StatsPackage.StatsManager;

import java.util.ArrayList;
import java.util.Collections;

/**
 Class for managing Reaction Time Stats

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
