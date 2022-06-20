package com.fence.views.userViews;

import com.fence.pojo.Good;
import com.fence.pojo.Store;
import com.fence.service.StoreService;
import com.fence.service.UserService;
import com.fence.utils.MainUtil;

import java.util.ArrayList;
import java.util.List;

public class StoreView {
    public static void view() {
        // TODO: 购买商品
        // TODO：加入购物车
        List<Good> res = StoreService.getAllGoods();
        System.out.println("序号 商店 id 名字 价格 库存");
        for(int i = 0; i < res.size(); i++) {
            System.out.println(i + " " + StoreService.getStoreNameById(res.get(i).getStoreID()) + " " +
                    res.get(i).getId() + " " + res.get(i).getName() + " " + res.get(i).getPrice() + " " +
                    res.get(i).getStock());
        }
        System.out.println("0: 返回上一级");
        System.out.println("1: 加入购物车");
        System.out.println("2: 购买商品");
    }

    public static void operate() {

        while(true){
            view();
            if(MainUtil.sc.hasNext()){
                int next = MainUtil.sc.nextInt();
                switch(next){
                    case 0: // 返回上一级
                        return;
                    case 1: // 加入购物车
                        System.out.println("请输入要加入的商品id：");
                        int id = MainUtil.sc.nextInt();
                        System.out.println("请输入要加入的数量：");
                        int num = MainUtil.sc.nextInt();
                        UserService.addToCar(StoreService.getGoodById(id), num);
                        break;
                    case 2: // 购买商品
                        System.out.println("请输入要购买的商品id：");
                        id = MainUtil.sc.nextInt();
                        System.out.println("请输入要购买的数量：");
                        num = MainUtil.sc.nextInt();
                        UserService.buyGood(StoreService.getGoodById(id), num);
                        break;
                }
            }
        }
    }
}
