package com.module_main.v;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a.a.a.library_base.arouter.RouterPath;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.module_main.R;

/**
 * Created by Administrator on 2019/7/24 0024.
 */
@Route(path = RouterPath.Main.O2)
public class O2Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView text = view.findViewById(R.id.text);
        text.setText("2222222222222");
    }
}
