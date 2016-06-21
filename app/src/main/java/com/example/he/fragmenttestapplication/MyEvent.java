package com.example.he.fragmenttestapplication;

import java.util.ArrayList;

/**
 * Created by He on 2016/5/24.
 */
public class MyEvent {

    public MyEvent() {
    }

    public MyEvent(ArrayList<String> dats) {
        this.dats = dats;
    }

    public ArrayList<String> dats;

    public ArrayList<String> getDats() {
        return dats;
    }
}
