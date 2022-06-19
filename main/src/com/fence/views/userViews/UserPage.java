package com.fence.views.userViews;

import com.fence.pojo.Good;
import com.fence.pojo.Store;
import com.fence.pojo.User;
import com.fence.service.UserService;
import com.fence.utils.MainUtil;

/*
用户相关页面
*/
// TODO: 余戬
public class UserPage {

    private static void view() {
        System.out.println("0：返回主页");
        System.out.println("1：展示用户信息"); // TODO
        System.out.println("2：展示商品");
        System.out.println("3：展示购物车");
        // TODO: 类：ShoppingCartView
            // TODO: 清空购物车
            // TODO: 购买商品
    }

    private static void operate() {
        while(true){
            view();
            if(MainUtil.sc.hasNext()){
                int next=MainUtil.sc.nextInt();
                switch(next){
                    case 0: // 返回上一级
                        return;
                    case 1: // 展示用户信息
                        // TODO
                        break;
                    case 2: // 展示商品
                        StoreView.view();
//                    case 3:


                }
            }
        }

        // 0 返回主页
        // 1 展示用户信息
        // 2 加入购物车
        // 3 直接购买商品
        // 4 清空购物车
        // 5 展示购物车
        // 6 移除购物车

    }


    // 用户主页
    public static void userPage() {

        operate();
    }
}
