package com.fence.pojo;

import java.util.ArrayList;

/*
用户类

成员变量：选择合适的数据类型和数据结构
ID
用户名
密码
密码提示词
余额
地址（可以多个）
已购商品
购物车

成员方法：
所有 get, set 方法

*/
public class User {
    private int id;
    private String username;
    private String password;
    private String passwordPrompt;
    private double balance;
    private ArrayList<String> address = new ArrayList<>();
    private ArrayList<Good> shoppingCart = new ArrayList<>();
    private ArrayList<Good> purchasedGoods = new ArrayList<>();

    public User() {
    }

    public User(int id, String username, String password, String passwordPrompt, double balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.passwordPrompt = passwordPrompt;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordPrompt() {
        return passwordPrompt;
    }

    public void setPasswordPrompt(String passwordPrompt) {
        this.passwordPrompt = passwordPrompt;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }

    public ArrayList<Good> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Good> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    // TODO: 银河之力

    public ArrayList<Good> getPurchasedGoods() {
        return purchasedGoods;
    }

    public void setPurchasedGoods(ArrayList<Good> purchasedGoods) {
        this.purchasedGoods = purchasedGoods;
    }

}
