package com.fence.views.userViews;

import com.fence.pojo.Good;
import com.fence.pojo.User;
import com.fence.service.UserService;

import java.util.Map;

public class UserView {
    public static void showUserInfo() {
        User user = UserService.getSignedUser();
        System.out.println("用户信息：");
        System.out.println("用户id：" + user.getId());
        System.out.println("用户名字：" + user.getUsername());
        System.out.println("用户密码：" + user.getPassword());
        System.out.println("用户密码提示词：" + user.getPasswordPrompt());
        System.out.println("用户余额：" + user.getBalance());
        System.out.println("用户地址：");
        for (String address : user.getAddress()) {
            System.out.println(address);
        }
    }

    public static void showShoppingCart() {
        User user = UserService.getSignedUser();
        System.out.println("购物车：");
        System.out.println("名称 价格 数量");
        for (Map.Entry<Good, Integer> entry : user.getShoppingCart().entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getKey().getPrice() + " " + entry.getValue());
        }
    }

    public static void showPurchasedGoods() {
        User user = UserService.getSignedUser();
        System.out.println("已购买商品：");
        System.out.println("名称 价格 数量");
        for (Map.Entry<Good, Integer> entry : user.getPurchasedGoods().entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getKey().getPrice() + " " + entry.getValue());
        }
    }
}
