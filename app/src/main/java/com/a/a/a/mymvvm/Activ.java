package com.a.a.a.mymvvm;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by Administrator on 2019/7/24 0024.
 */

//@Route(path = RouterPath.Main.O1)
public class Activ extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("ddddddddd");
        setContentView(textView);

    }
}
