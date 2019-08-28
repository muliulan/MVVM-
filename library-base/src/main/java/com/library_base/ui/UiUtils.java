package com.library_base.ui;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2019/8/28 0028.
 */

public class UiUtils {

    public static UiUtils uiutils;
    //设计图尺寸
    public static final float STANDARD_WIDTH=1080f;
    public static final float STANDARD_HEIGHT=1920f;

    //实际设备尺寸 宽高和状态栏高度
    public static float displayMetricsWidth;
    public static float displayMetricsHeight;
    public static float systemBarHeight;

    public static UiUtils getUiUtils(Context context){
        if(uiutils == null){
            uiutils = new UiUtils(context);
        }
        return uiutils;
    }

    public static UiUtils getUiUtils(){
        if(uiutils == null){
            throw new RuntimeException("先初始化UIUtils");
        }
        return uiutils;
    }
    private UiUtils(Context context){
        WindowManager windowManager= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        systemBarHeight = getSystemBarHeight(context);
        if(displayMetrics.widthPixels>displayMetrics.heightPixels){
            this.displayMetricsWidth=(float)(displayMetrics.heightPixels);
            this.displayMetricsHeight=(float)(displayMetrics.widthPixels-systemBarHeight);
        }else {
//                竖屏
            this.displayMetricsWidth=(float)(displayMetrics.widthPixels);
            this.displayMetricsHeight=(float)(displayMetrics.heightPixels-systemBarHeight);
        }
    }

    /** 宽的百分比
     */
    public float getWidthScaleValue(){
        return displayMetricsWidth/STANDARD_WIDTH;
    }

    /** 高的百分比
     */
    public float getHeightScaleValue(){
        return ((displayMetricsHeight))/(STANDARD_HEIGHT-systemBarHeight);
    }

    public int getWidth(int width) {
        return Math.round((float)width * this.displayMetricsWidth / STANDARD_WIDTH);
    }
    public int getHeight(int height) {
        return Math.round((float)height * this.displayMetricsHeight / (STANDARD_HEIGHT-systemBarHeight));
    }

    /** 状态栏高度
     */
    private int getSystemBarHeight(Context context){
        return getValue(context,"com.android.internal.R$dimen","system_bar_height",48);
    }
    private int getValue(Context context, String dimeClass, String system_bar_height, int defaultValue) {
//        com.android.internal.R$dimen    system_bar_height   状态栏的高度
        try {
            Class<?> clz=Class.forName(dimeClass);
            Object object = clz.newInstance();
            Field field=clz.getField(system_bar_height);
            int id=Integer.parseInt(field.get(object).toString());
            return context.getResources().getDimensionPixelSize(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
