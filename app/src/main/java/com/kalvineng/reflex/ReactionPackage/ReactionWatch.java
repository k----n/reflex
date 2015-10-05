package com.kalvineng.reflex.ReactionPackage;

import java.util.Random;

/**
 * Created by Kalvin on 2015-10-01.
 */
public class ReactionWatch {
    private long timeStart;

    // random time adapted from http://stackoverflow.com/a/363692
    private long lowerRange = 10;
    private long upperRange = 2000;
    private Random r = new Random();
    private long timeElapsed;
    private long randomTime = lowerRange + ((long)(r.nextDouble()*(upperRange + 1 - lowerRange)));

    public long getReactionTime() {
        return timeElapsed - randomTime;
    }

    public long getRandomTime() {
        return randomTime;
    }

    public void start() {
        timeStart = System.currentTimeMillis();
    }

    public void reset(){
        timeStart = System.currentTimeMillis();
        randomTime = lowerRange + ((long)(r.nextDouble()*(upperRange + 1 - lowerRange)));
    }

    public Boolean check(){
        timeElapsed = System.currentTimeMillis() - timeStart;
        if (timeElapsed < randomTime){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
