package com.kalvineng.reflex.ReactionPackage;

import java.util.Random;

/**
 Class to keep track of presses for calculating reaction time

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
