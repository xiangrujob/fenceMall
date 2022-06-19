package com.fence.views.userViews;

import com.fence.pojo.Good;
import com.fence.pojo.Store;
import com.fence.service.StoreService;

import java.util.ArrayList;
import java.util.List;

public class StoreView {
    public static void view() {
        // TODO: 购买商品
        // TODO：加入购物车
        List<Good> res = StoreService.getAllGoods();
        for(int i = 0; i < res.size(); i++) {
            System.out.println(i + " " + res.get(i).getId() + " " + res.get(i).getPrice());
        }
    }
}
