package com.kalvineng.reflex.StatsPackage;

import java.util.ArrayList;
import java.util.Collections;

/**
 Class to parse Buzzer data into meaningful data

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
public class StatsBuzzerParser {

    public String countPlayer(int mode, int player, String buzz, ArrayList<String> records){
        if(!records.isEmpty()) {
            int times = Collections.frequency(records, buzz); // adapted from http://stackoverflow.com/a/2459753 08/01/15
            return Integer.toString(mode) + "p: Player " + Integer.toString(player) + " buzzed " + Integer.toString(times) + " times\n";
        }
        else {
            return Integer.toString(mode) + "p: Player " + Integer.toString(player) + " Buzzed: " + Integer.toString(0) + " times\n";
        }
    }
}
