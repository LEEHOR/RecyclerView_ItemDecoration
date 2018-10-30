package com.example.test.recycleviewstickyheader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Leehor
 * on 2018/10/29
 * on 14:03
 */
public abstract class BaseActivity extends AppCompatActivity {
    private  Unbinder unbinder;
    public abstract int binLayout();

    public abstract void initView();

    public abstract void initListener();

    public abstract void initData();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binLayout());
        unbinder = ButterKnife.bind(this);
        initView();
        initListener();
        initData();
    }
}
