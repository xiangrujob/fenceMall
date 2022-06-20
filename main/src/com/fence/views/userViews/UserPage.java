package com.fence.views.userViews;

import com.fence.pojo.Good;
import com.fence.pojo.Store;
import com.fence.pojo.User;
import com.fence.service.UserService;
import com.fence.utils.MainUtil;

/*
用户相关页面
*/
public class UserPage {

    private static void view() {
        System.out.println("0：返回主页");
        System.out.println("1：展示用户信息");
        System.out.println("2：展示所有商品");
        System.out.println("3：展示购物车");
        System.out.println("4：展示已购买商品");
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
                        UserView.showUserInfo();
                        break;
                    case 2: // 展示所有商品
                        StoreView.operate();
                        break;
                    case 3: // 展示购物车
                        UserView.showShoppingCart();
                        break;
                    case 4: // 展示已购买商品
                        UserView.showPurchasedGoods();
                }
            }
        }
    }


    // 用户主页
    public static void userPage() {
        operate();
    }
}
