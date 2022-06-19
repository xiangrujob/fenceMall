package com.fence.service;

import com.fence.pojo.Good;
import com.fence.pojo.Store;
import com.fence.pojo.User;

import java.util.ArrayList;

// TODO: 楠竹

public class UserService {

    private static final ArrayList<User> users = init();
    private static User signedUser;

    public static ArrayList<User> init() {

        User user1 = new User(11, "user1", "555", "5", 100);
        User user2 = new User(12, "user2", "555", "5", 100);
        User user3 = new User(13, "user3", "555", "5", 100);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return userList;

    }

    public static boolean login(int id, String password) {
        for (User user : users) {
            if (user.getId() == id) {
                if (user.getPassword().equals(password)) {
                    signedUser = user;
                    return true;
                }
            }
        }
        return false;
    }
    
    // 加入购物车
    public static boolean addToCar(Good good) {
        signedUser.getShoppingCart().add(good);
        return false;
    }

    // 购买商品
    public static boolean buyGood(Good good) {
        if (signedUser.getBalance() < good.getPrice()) {
            return false;
        } else {
            signedUser.setBalance(signedUser.getBalance() - good.getPrice());
            signedUser.getPurchasedGoods().add(good);
            StoreService.sellGood(good);
            return true;
        }
    }

    // 清空购物车：指全部下单购买

    public static boolean clearCar(){

        for (Good good : signedUser.getShoppingCart()) {
            buyGood(good);
        }
        return true;
    }


    public static boolean moveGoodOutOfCar(Good good){
        return signedUser.getShoppingCart().remove(good);
    }

}

