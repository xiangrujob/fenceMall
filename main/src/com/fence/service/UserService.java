package com.fence.service;

import com.fence.pojo.Good;
import com.fence.pojo.Store;
import com.fence.pojo.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserService {

    private static final ArrayList<User> users = init();
    private static int userNum;
    private static User signedUser;

    public static ArrayList<User> init() {

        User user1 = new User(1, "吴签", "2", "1+1", 10000000);
        User user2 = new User(2, "张三", "2", "1+1", 1000);
        User user3 = new User(3, "罗翔", "2", "1+1", 100000);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        userNum = 3;

        return userList;
    }

    public static boolean signUp(String username, String password, String passwordPrompt, int balance) {
        User user = new User(userNum + 1, username, password, passwordPrompt, balance);
        users.add(user);
        userNum++;
        return true;
    }

    public static boolean logIn(int id, String password) {
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

    public static User getSignedUser() {
        return signedUser;
    }
    
    // 加入购物车
    public static boolean addToCar(Good good, int num) {
        HashMap<Good, Integer> goods = signedUser.getShoppingCart();
        if (!goods.containsKey(good)) {
            goods.put(good, num);
        } else {
            goods.put(good, signedUser.getShoppingCart().get(good) + num);
        }
        return true;
    }

    // 购买商品
    public static boolean buyGood(Good good, int num) {
        if (signedUser.getBalance() < good.getPrice() * num) {
            return false;
        } else {
            signedUser.setBalance(signedUser.getBalance() - good.getPrice() * num);
            HashMap<Good, Integer> goods = signedUser.getPurchasedGoods();
            if (!goods.containsKey(good)) {
                goods.put(good, num);
            } else {
                goods.put(good, goods.get(good) + num);
            }
            StoreService.sellGood(good);
            return true;
        }
    }

    // 清空购物车
    public static boolean clearCar(){
        for (Map.Entry<Good, Integer> entry : signedUser.getShoppingCart().entrySet()) {
            buyGood(entry.getKey(), entry.getValue());
        }
        signedUser.getShoppingCart().clear();
        return true;
    }

    // 移除商品
    public static boolean moveGoodOutOfCar(Good good, int num){
        HashMap<Good, Integer> goods = signedUser.getShoppingCart();
        if (goods.containsKey(good)) {
            if (goods.get(good) < num) {
                return false;
            } else if (goods.get(good) == num) {
                goods.remove(good);
            } else {
                goods.put(good, goods.get(good) - num);
            }
        }
        return true;
    }

}

