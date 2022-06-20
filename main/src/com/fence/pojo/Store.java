package com.fence.pojo;

import java.util.ArrayList;

/*
商家类
成员变量：选择合适的数据类型和数据结构
ID
商家名
商品
营收额

成员方法：
所有 get, set 方法

*/
public class Store {
    private int id;//ID
    private String password; // 密码
    private String name;//商家名
    private ArrayList<Good> goods;//商品
    private double earnPrice;//营收额

    public Store() {
    }

    public Store(int id, String password, String name, ArrayList<Good> goods, double earnPrice) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.goods = goods;
        this.earnPrice = earnPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Good> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<Good> goods) {
        this.goods = goods;
    }

    public double getEarnPrice() {
        return earnPrice;
    }

    public void setEarnPrice(double earnPrice) {
        this.earnPrice = earnPrice;
    }
}
