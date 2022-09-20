package com.prasunpersonal.snakeandladder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public class MainBoard extends View {


    public MainBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int width, int height){
        super.onMeasure(width, height);
        int dimension = Math.min(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(dimension, dimension);
    }
}
