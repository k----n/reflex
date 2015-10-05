package com.kalvineng.reflex.StatsPackage;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kalvin on 2015-10-04.
 */
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
