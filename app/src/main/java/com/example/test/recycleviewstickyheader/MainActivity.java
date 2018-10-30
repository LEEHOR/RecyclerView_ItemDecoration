package com.example.test.recycleviewstickyheader;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.btn_1)
    Button btn_1;
    @BindView(R.id.btn_2)
    Button btn_2;
    @BindView(R.id.btn_3)
    Button btn_3;
    @BindView(R.id.btn_4)
    Button btn_4;
    @BindView(R.id.btn_5)
    Button btn_5;


    @Override
    public int binLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this,RecyclerViewActivity.class);
        switch (v.getId()){
            case R.id.btn_1:
                intent.putExtra("type",1);
                break;
            case R.id.btn_2:
                intent.putExtra("type",2);
                break;
            case R.id.btn_3:
                intent.putExtra("type",3);
                break;
            case R.id.btn_4:
                intent.putExtra("type",4);
                break;
            case R.id.btn_5:
                intent.putExtra("type",5);
                break;
        }
        startActivity(intent);
    }
}
