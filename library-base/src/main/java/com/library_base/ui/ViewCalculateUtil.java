package com.library_base.ui;

import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2019/8/28 0028.
 *
 *  使用方法            传入的都是PX
 *              ViewCalculateUtil.setViewLinearLayoutParam(tvText4, 1080, 100, 0, 0, 0, 0); //设置控件位置
                ViewCalculateUtil.setTextSize(tvText3,30);  //设置字体大小
 */

public class ViewCalculateUtil {

    public static void setViewRelativeLayoutParam(View view, int width, int height, int topMargin, int bottomMargin, int lefMargin, int rightMargin){
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();

        if (layoutParams != null) {
            if (width != RelativeLayout.LayoutParams.MATCH_PARENT && width != RelativeLayout.LayoutParams.WRAP_CONTENT && width != RelativeLayout.LayoutParams.FILL_PARENT){
                layoutParams.width = UiUtils.getUiUtils().getWidth(width);
            }
            else
            {
                layoutParams.width = width;
            }
            if (height != RelativeLayout.LayoutParams.MATCH_PARENT && height != RelativeLayout.LayoutParams.WRAP_CONTENT && height != RelativeLayout.LayoutParams.FILL_PARENT)
            {
                layoutParams.height = UiUtils.getUiUtils( ).getHeight(height);
            }
            else
            {
                layoutParams.height = height;
            }

            layoutParams.topMargin = UiUtils.getUiUtils( ).getHeight(topMargin);
            layoutParams.bottomMargin = UiUtils.getUiUtils( ).getHeight(bottomMargin);
            layoutParams.leftMargin = UiUtils.getUiUtils( ).getWidth(lefMargin);
            layoutParams.rightMargin = UiUtils.getUiUtils( ).getWidth(rightMargin);
            view.setLayoutParams(layoutParams);
        }
        else
        {
        }

    }
    public static void setTextSize(TextView view, int size)
    {
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, UiUtils.getUiUtils().getHeight(size));
    }

    public static void setViewGroupLayoutParam(View view, int width, int height)
    {

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width != RelativeLayout.LayoutParams.MATCH_PARENT && width != RelativeLayout.LayoutParams.WRAP_CONTENT && width != RelativeLayout.LayoutParams.FILL_PARENT)
        {
            layoutParams.width = UiUtils.getUiUtils( ).getWidth(width);
        }
        else
        {
            layoutParams.width = width;
        }
        if (height != RelativeLayout.LayoutParams.MATCH_PARENT && height != RelativeLayout.LayoutParams.WRAP_CONTENT && height != RelativeLayout.LayoutParams.FILL_PARENT)
        {
            layoutParams.height = UiUtils.getUiUtils( ).getHeight(height);
        }
        else
        {
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }
    public static void setViewLinearLayoutParam(View view, int width, int height){
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (width != RelativeLayout.LayoutParams.MATCH_PARENT && width != RelativeLayout.LayoutParams.WRAP_CONTENT && width != RelativeLayout.LayoutParams.FILL_PARENT)
        {
            layoutParams.width = UiUtils.getUiUtils( ).getWidth(width);
        }
        else
        {
            layoutParams.width = width;
        }
        if (height != RelativeLayout.LayoutParams.MATCH_PARENT && height != RelativeLayout.LayoutParams.WRAP_CONTENT && height != RelativeLayout.LayoutParams.FILL_PARENT)
        {
            layoutParams.height = UiUtils.getUiUtils( ).getHeight(height);
        }
        else
        {
            layoutParams.height = height;
        }

        view.setLayoutParams(layoutParams);
    }
    /**
     * 设置LinearLayout中 view的高度宽度
     *
     * @param view
     * @param width
     * @param height
     */
    public static void setViewLinearLayoutParam(View view, int width, int height, int topMargin, int bottomMargin, int lefMargin, int rightMargin)  {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (width != RelativeLayout.LayoutParams.MATCH_PARENT && width != RelativeLayout.LayoutParams.WRAP_CONTENT && width != RelativeLayout.LayoutParams.FILL_PARENT)
        {
            layoutParams.width = UiUtils.getUiUtils( ).getWidth(width);
        }
        else
        {
            layoutParams.width = width;
        }
        if (height != RelativeLayout.LayoutParams.MATCH_PARENT && height != RelativeLayout.LayoutParams.WRAP_CONTENT && height != RelativeLayout.LayoutParams.FILL_PARENT)
        {
            layoutParams.height = UiUtils.getUiUtils( ).getHeight(height);
        }
        else
        {
            layoutParams.height = height;
        }

        layoutParams.topMargin = UiUtils.getUiUtils( ).getHeight(topMargin);
        layoutParams.bottomMargin = UiUtils.getUiUtils( ).getHeight(bottomMargin);
        layoutParams.leftMargin = UiUtils.getUiUtils( ).getWidth(lefMargin);
        layoutParams.rightMargin = UiUtils.getUiUtils( ).getWidth(rightMargin);
        view.setLayoutParams(layoutParams);
    }


}
