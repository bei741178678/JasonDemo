package com.jason.demo.jasondemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jason on 2017-3-21.
 */

public class ShareUtils {
    public static final String NAME = "JASON";

    /**
     *添加String
     * @param context
     * @param key
     * @param value
     */
    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    /**
     * 获取String
     * @param context
     * @param key
     * @param defString
     * @return
     */
    public static String getString(Context context, String key, String defString) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defString);
    }

    /**
     * 添加int
     * @param context
     * @param key
     * @param value
     */
    public static void putInt(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    /**
     * 获取int
     * @param context
     * @param key
     * @param defInt
     * @return
     */
    public static int getInt(Context context, String key, int defInt) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defInt);
    }

    /**
     * 添加boolean
     * @param context
     * @param key
     * @param value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * 获取boolean
     * @param context
     * @param key
     * @param defInt
     * @return
     */
    public static boolean getBoolean(Context context, String key, boolean defInt) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defInt);
    }

    /**
     * 删除单个键值对
     * @param context
     * @param key
     */
    public static void deleteShare(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().remove(key).commit();
    }

    /**
     * 删除全部
     * @param context
     */
    public  static  void deleteAll(Context context){
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }

}
