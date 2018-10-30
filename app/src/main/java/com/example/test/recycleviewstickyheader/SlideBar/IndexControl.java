package com.example.test.recycleviewstickyheader.SlideBar;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Map;

/**
 * Created by Leehor
 * on 2018/10/29
 * on 14:55
 */
public class IndexControl {

    private final ListView listView;

    private final TextView tv_hint;

    private final Map<String, Integer> letterMap;

    public IndexControl(ListView contactsListView, SideBar sideBar,
                        TextView tv_hint, Map<String, Integer> letterMap) {
        this.listView = contactsListView;
        this.tv_hint = tv_hint;
        this.letterMap = letterMap;
        sideBar.setOnTouchingLetterChangedListener(new LetterChangedListener());
    }

    private class LetterChangedListener implements SideBar.OnTouchingLetterChangedListener {

        @Override
        public void onHit(String letter) {
            tv_hint.setVisibility(View.VISIBLE);
            tv_hint.setText(letter);
            int index = -1;
            if ("↑".equals(letter)) {
                index = 0;
            } else if (letterMap.containsKey(letter)) {
                index = letterMap.get(letter);
            }
            if (index < 0) {
                return;
            }
            index += listView.getHeaderViewsCount();
            if (index >= 0 && index < listView.getCount()) {
                listView.setSelectionFromTop(index, 0);
            }
        }

        @Override
        public void onCancel() {
            tv_hint.setVisibility(View.INVISIBLE);
        }
    }

}
