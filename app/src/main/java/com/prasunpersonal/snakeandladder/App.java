package com.prasunpersonal.snakeandladder;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

public class App extends Application {
    public static final Map<Integer, Integer> POSITIONS = new HashMap<>();
    static {
        POSITIONS.put(2, 59);
        POSITIONS.put(5, 26);
        POSITIONS.put(10, 69);
        POSITIONS.put(24, 4);
        POSITIONS.put(34, 55);
        POSITIONS.put(36, 0);
        POSITIONS.put(46, 8);
        POSITIONS.put(62, 95);
        POSITIONS.put(64, 58);
        POSITIONS.put(67, 92);
        POSITIONS.put(86, 53);
        POSITIONS.put(91, 68);
        POSITIONS.put(98, 61);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
