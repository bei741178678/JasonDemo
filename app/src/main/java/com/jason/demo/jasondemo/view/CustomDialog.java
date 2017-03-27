package com.jason.demo.jasondemo.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.jason.demo.jasondemo.R;

/**
 * Created by jason on 2017-3-22.
 */

public class CustomDialog extends Dialog {
    public CustomDialog(Context context,int layoutId,int style){
        this(context, WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT,layoutId,style, Gravity.CENTER);
    }
    public CustomDialog(Context context,int width,int height,int layoutId,int style,int graviry,int anim){
        super(context,style);
        setContentView(layoutId);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = width;
        layoutParams.height = height;
        layoutParams.gravity = graviry;
        window.setAttributes(layoutParams);
        window.setWindowAnimations(anim);
    }
    public CustomDialog(Context context,int width,int height,int layoutId,int style,int graviry){
        this(context,width,height,layoutId,style,graviry, R.style.pop_anim_style);
    }
}
