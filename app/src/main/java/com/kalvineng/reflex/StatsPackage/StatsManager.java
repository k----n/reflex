package com.kalvineng.reflex.StatsPackage;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Kalvin on 2015-10-01.
 */
public class StatsManager {

    // taken and adapted from joshua2ua https://github.com/joshua2ua/lonelyTwitter/blob/f15tuesday/app/src/main/java/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java 08/01/15
    public ArrayList<Long> loadReactFile(Context c, String file) {
        try {
            FileInputStream fis = c.openFileInput(file);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            // Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 2015-09-22
            Type listType = new TypeToken<ArrayList<Long>>() {}.getType();
            return gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            return new ArrayList<Long>();
        }
    }

    // taken and adapted from joshua2ua https://github.com/joshua2ua/lonelyTwitter/blob/f15tuesday/app/src/main/java/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java 08/01/15
    public ArrayList<String> loadBuzzFile(Context c, String file) {
        try {
            FileInputStream fis = c.openFileInput(file);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            // Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 2015-09-22
            Type listType = new TypeToken<ArrayList<String>>() {}.getType();
            return gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            return new ArrayList<String>();
        }
    }

    // taken and adapted from joshua2ua https://github.com/joshua2ua/lonelyTwitter/blob/f15tuesday/app/src/main/java/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java 08/01/15
    public void saveReactStat(Context c, String file, ArrayList<Long> records) {
        try {
            FileOutputStream fos = c.openFileOutput(file, 0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(records, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // taken and adapted from joshua2ua https://github.com/joshua2ua/lonelyTwitter/blob/f15tuesday/app/src/main/java/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java 08/01/15
    public void saveBuzzStat(Context c, String file, ArrayList<String> records) {
        try {
            FileOutputStream fos = c.openFileOutput(file, 0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(records, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
