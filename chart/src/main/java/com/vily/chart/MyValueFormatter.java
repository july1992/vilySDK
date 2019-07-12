package com.vily.chart;

import android.util.Log;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.DecimalFormat;

/**
 *  * description :  年  下标

 *  
 **/
public class MyValueFormatter extends ValueFormatter {

    private static final String TAG = "MyXFormatter";
    private final DecimalFormat mFormat;
    private String suffix;

    private int sumCount=0;
    private int currCount=0;
    private String title="";

    public MyValueFormatter(String suffix) {
        mFormat = new DecimalFormat("###,###,###,##0.0");
        this.suffix = suffix;
    }

    public MyValueFormatter() {
        mFormat = new DecimalFormat("###,###,###,##0.0");
    }
    public MyValueFormatter(int count,String value) {
        sumCount=count;
        currCount=0;
        title=value;
        mFormat = new DecimalFormat("###,###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value) {
        return mFormat.format(value) + suffix;
    }


    @Override
    public String getAxisLabel(float value, AxisBase axis) {
        Log.i(TAG, "value: ---------value:"+value+"---sumCount:"+sumCount+"---currCount:"+currCount);


        if(currCount==sumCount){
            return title;
        }
        currCount++;
        return "";

    }

}