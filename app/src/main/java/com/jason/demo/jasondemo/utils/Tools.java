package com.jason.demo.jasondemo.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by jason on 2017-3-21.
 */

public class Tools {
    /**
     * 设置字体
     * @param context
     * @param textView
     */
    public static void setFont(Context context, TextView textView){
        Typeface fromAsset = Typeface.createFromAsset(context.getAssets(), "fonts/symbol.ttf");
        textView.setTypeface(fromAsset);
    }
}
