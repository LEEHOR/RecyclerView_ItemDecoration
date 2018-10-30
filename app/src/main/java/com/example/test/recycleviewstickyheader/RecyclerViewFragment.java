package com.example.test.recycleviewstickyheader;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.test.recycleviewstickyheader.SlideBar.SideBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Leehor
 * on 2018/10/29
 * on 14:37
 */
public class RecyclerViewFragment extends BaseFragment {
    private int type;
    @BindView(R.id.recycle_re)
    RecyclerView recyclerView;
    @BindView(R.id.recycler_title)
    TextView recycler_title;
    @BindView(R.id.slideBar)
    SideBar sideBar;
    @BindView(R.id.textdialog)
    TextView textdialog;
    private List<Bean> list = new ArrayList<>();
    private  List<Bean> sortEntity;

    private LinearLayoutManager linearLayoutManager;

    private RecyclerView_adapter adapter;

    public static RecyclerViewFragment getInstance(int type) {
        RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        recyclerViewFragment.setArguments(bundle);
        return recyclerViewFragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.recycle_fragment;
    }

    @Override
    public void initView() {
        list.add(new Bean("安徽", "A"));
        list.add(new Bean("合肥", "H"));
        list.add(new Bean("芜湖", "W"));
        list.add(new Bean("蚌埠", "B"));
        list.add(new Bean("淮南", "H"));
        list.add(new Bean("马鞍山", "M"));
        list.add(new Bean("淮北", "H"));
        list.add(new Bean("铜陵", "T"));
        list.add(new Bean("安庆", "A"));
        list.add(new Bean("淮北", "H"));
        list.add(new Bean("铜陵", "T"));
        list.add(new Bean("安庆", "A"));
        list.add(new Bean("黄山", "H"));
        list.add(new Bean("滁州", "Z"));
        list.add(new Bean("阜阳", "F"));
        list.add(new Bean("宿州", "S"));
        list.add(new Bean("六安", "L"));
        list.add(new Bean("亳州", "B"));
        list.add(new Bean("池州", "C"));
        list.add(new Bean("宣城", "X"));


        list.add(new Bean("安徽", "A"));
        list.add(new Bean("合肥", "H"));
        list.add(new Bean("芜湖", "W"));
        list.add(new Bean("蚌埠", "B"));
        list.add(new Bean("淮南", "H"));
        list.add(new Bean("淮北", "H"));
        list.add(new Bean("铜陵", "T"));
        list.add(new Bean("安庆", "A"));
        list.add(new Bean("马鞍山", "M"));
        list.add(new Bean("淮北", "H"));
        list.add(new Bean("铜陵", "T"));
        list.add(new Bean("安庆", "A"));
        list.add(new Bean("黄山", "H"));
        list.add(new Bean("滁州", "Z"));
        list.add(new Bean("阜阳", "F"));
        list.add(new Bean("宿州", "S"));
        list.add(new Bean("六安", "L"));
        list.add(new Bean("亳州", "B"));
        list.add(new Bean("池州", "C"));
        list.add(new Bean("宣城", "X"));


        list.add(new Bean("安徽", "A"));
        list.add(new Bean("合肥", "H"));
        list.add(new Bean("芜湖", "W"));
        list.add(new Bean("蚌埠", "B"));
        list.add(new Bean("淮南", "H"));
        list.add(new Bean("淮北", "H"));
        list.add(new Bean("铜陵", "T"));
        list.add(new Bean("安庆", "A"));
        list.add(new Bean("马鞍山", "M"));
        list.add(new Bean("淮北", "H"));
        list.add(new Bean("铜陵", "T"));
        list.add(new Bean("安庆", "A"));
        list.add(new Bean("黄山", "H"));
        list.add(new Bean("滁州", "Z"));
        list.add(new Bean("阜阳", "F"));
        list.add(new Bean("宿州", "S"));
        list.add(new Bean("六安", "L"));
        list.add(new Bean("亳州", "B"));
        list.add(new Bean("池州", "C"));
        list.add(new Bean("宣城", "X"));


        list.add(new Bean("安徽", "A"));
        list.add(new Bean("合肥", "H"));
        list.add(new Bean("芜湖", "W"));
        list.add(new Bean("蚌埠", "B"));
        list.add(new Bean("淮南", "H"));
        list.add(new Bean("淮北", "H"));
        list.add(new Bean("铜陵", "T"));
        list.add(new Bean("安庆", "A"));
        list.add(new Bean("马鞍山", "M"));
        list.add(new Bean("淮北", "H"));
        list.add(new Bean("铜陵", "T"));
        list.add(new Bean("安庆", "A"));
        list.add(new Bean("黄山", "H"));
        list.add(new Bean("滁州", "Z"));
        list.add(new Bean("阜阳", "F"));
        list.add(new Bean("宿州", "S"));
        list.add(new Bean("六安", "L"));
        list.add(new Bean("亳州", "B"));
        list.add(new Bean("池州", "C"));
        list.add(new Bean("宣城", "X"));
        linearLayoutManager = new LinearLayoutManager(getActivity());
        adapter = new RecyclerView_adapter(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        sortEntity = Bean.getSortEntity(list);//排序
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onHit(String letter) {
                textdialog.setVisibility(View.VISIBLE);
                textdialog.setText(letter);
                if (sortEntity ==null || sortEntity.isEmpty()) return;
                if (TextUtils.isEmpty(letter)) return;
                int size=sortEntity.size();
                for (int i = 0; i <size ; i++) {
                  if (TextUtils.equals(letter.substring(0,1),sortEntity.get(i).getCity_code().substring(0,1).toUpperCase())){
                        if (linearLayoutManager !=null){
                            linearLayoutManager.scrollToPositionWithOffset(i,0);
                            return;
                        }
                  }
                }
            }

            @Override
            public void onCancel() {
                textdialog.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void initData() {

        if (getArguments() != null) {
            type = getArguments().getInt("type");
        }
        switch (type) {
            case 1:
                recycler_title.setText("1");
                recyclerView.addItemDecoration(new RecyclerSimplePadding(getActivity()));
               // adapter.setData(list);
                break;
            case 2:
                recycler_title.setText("2");
               // adapter.setData(list);

                recyclerView.addItemDecoration(new RecyclerSimplePadding_color(getActivity()));
                break;
            case 3:
                recycler_title.setText("3");
               // adapter.setData(list);
                recyclerView.addItemDecoration(new RecyclerSimplePadding_color(getActivity()));
                recyclerView.addItemDecoration(new RecyclerViewItemDecoration_table(getActivity()));
                break;
            case 4:
                recycler_title.setText("4");
                recyclerView.addItemDecoration(new RecyclerSimplePadding_color(getActivity()));
                recyclerView.addItemDecoration(new RecyclerViewItemDecoration_section(getActivity(), new RecyclerViewItemDecoration_section.DecorationCallback() {
                    @Override
                    public long getGroupId(int position) {
                        return Character.toUpperCase(sortEntity.get(position).getCity_code().charAt(0));
                    }

                    @Override
                    public String getGroupFirstLine(int position) {
                        return sortEntity.get(position).getCity_code().substring(0,1).toUpperCase();
                    }
                }) );
               // adapter.setData(list);
                break;
            case 5:
                recycler_title.setText("5");
                recyclerView.addItemDecoration(new RecyclerSimplePadding_color(getActivity()));
                recyclerView.addItemDecoration(new RecyclerViewItemDecoration_StickyHeader(getActivity(), new RecyclerViewItemDecoration_StickyHeader.DecorationCallback() {
                    @Override
                    public long getGroupId(int position) {
                        return Character.toUpperCase(sortEntity.get(position).getCity_code().charAt(0));
                    }

                    @Override
                    public String getGroupFirstLine(int position) {
                        return sortEntity.get(position).getCity_code().substring(0,1).toUpperCase();
                    }
                }));
                break;
        }
        adapter.setData(sortEntity);
        adapter.notifyDataSetChanged();

    }
}
