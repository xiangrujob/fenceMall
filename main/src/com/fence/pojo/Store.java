package com.fence.pojo;

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
    private String name;//商家名
    private Good[] goods;//商品
    private double earnPrice;//营收额

    public Store() {
    }

    public Store(int id, String name, Good[] goods, double earnPrice) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Good[] getGoods() {
        return goods;
    }

    public void setGoods(Good[] goods) {
        this.goods = goods;
    }

    public double getEarnPrice() {
        return earnPrice;
    }

    public void setEarnPrice(double earnPrice) {
        this.earnPrice = earnPrice;
    }
    // TODO: 银河之力
}
