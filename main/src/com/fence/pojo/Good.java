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
    private int id; // id
    private String name; // 名称
    private double price;// 价格
    private int stock; // 库存
    private int storeID; // 所属商家 id

    public Good() {
    }

    public Good(int id, String name, double price, int stock, int storeID) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


}
