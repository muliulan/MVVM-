package com.library_base.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2019/8/28 0028.
 */

public class UILinearLayout extends LinearLayout{

    private boolean flag=true;

    public UILinearLayout(Context context) {
        super(context);
    }

    public UILinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public UILinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (flag) {
            flag = false;
            float scaleX = UiUtils.getUiUtils(getContext()).getWidthScaleValue();
            float scaleY = UiUtils.getUiUtils(getContext()).getHeightScaleValue();
            int childCount = this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = this.getChildAt(i);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) child.getLayoutParams();
                layoutParams.width=(int) (layoutParams.width * scaleX);
                layoutParams.height = (int) (layoutParams.height * scaleY);
                layoutParams.leftMargin = (int) (layoutParams.leftMargin * scaleX);
                layoutParams.rightMargin = (int) (layoutParams.rightMargin * scaleX);
                layoutParams.topMargin = (int) (layoutParams.topMargin * scaleY);
                layoutParams.bottomMargin = (int) (layoutParams.bottomMargin * scaleY);
            }
        }

    }
}
