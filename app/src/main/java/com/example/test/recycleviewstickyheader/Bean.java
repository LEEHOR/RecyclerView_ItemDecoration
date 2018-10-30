package com.example.test.recycleviewstickyheader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Leehor
 * on 2018/10/29
 * on 14:55
 */
public class Bean {
    private String city_name;
    private String city_code;

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public Bean(String city_name, String city_code) {
        this.city_name = city_name;
        this.city_code = city_code;
    }

    public Bean() {

    }
    public static List<Bean> getSortEntity(List<Bean> list){
        Collections.sort(list, new Comparator<Bean>() {
            @Override
            public int compare(Bean o1, Bean o2) {
                return o1.getCity_code().compareTo(o2.getCity_code());
            }
        });
     return  list;
    }
}
