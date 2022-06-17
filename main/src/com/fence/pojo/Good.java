package com.fence.pojo;

/*
商品类
成员变量：
ID
价格
库存
所属商家ID

*/
public class Good {
    private int id;//ID
    private double price;//价格
    private int stock;//库存
    private int storeID;//所属商家ID

    public Good() {
    }

    public Good(int id, double price, int stock, int storeID) {
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.storeID = storeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }
    //ID


    // TODO: 银河之力
}
