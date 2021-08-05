package com.example.studyretrofit2.network.vo;

import java.util.ArrayList;

public class MovieDataVO {
    int total;
    ArrayList<MovieItemVO> items;

    public MovieDataVO(int total, ArrayList<MovieItemVO> items) {
        this.total = total;
        this.items = items;
    }

    public ArrayList<MovieItemVO> getItems() {
        return items;
    }

    public void setItems(ArrayList<MovieItemVO> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
