package com.example.test.recycleviewstickyheader;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Leehor
 * on 2018/10/29
 * on 14:14
 */
public class RecyclerViewActivity extends BaseActivity {
    private FragmentTransaction fragmentTransaction;
    @Override
    public int binLayout() {
        return R.layout.recycleview_activity;
    }

    @Override
    public void initView() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
         fragmentTransaction = supportFragmentManager.beginTransaction();

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        int type = getIntent().getIntExtra("type",1);
        switch (type){
            case 1:
                fragmentTransaction.replace(R.id.main_fragment,RecyclerViewFragment.getInstance(1));
                break;
            case 2:
                fragmentTransaction.replace(R.id.main_fragment,RecyclerViewFragment.getInstance(2));
                break;
            case 3:
                fragmentTransaction.replace(R.id.main_fragment,RecyclerViewFragment.getInstance(3));
                break;
            case 4:
                fragmentTransaction.replace(R.id.main_fragment,RecyclerViewFragment.getInstance(4));
                break;
            case 5:
                fragmentTransaction.replace(R.id.main_fragment,RecyclerViewFragment.getInstance(5));
                break;
        }
        fragmentTransaction.commit();
    }
}
