package com.fence.views.storeViews;

import com.fence.pojo.Good;
import com.fence.pojo.Store;
import com.fence.service.StoreService;
import com.fence.utils.MainUtil;
import com.fence.views.Index;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
商家界面
*/
public class StorePage {


    private static void view() {
        System.out.println("=====商家操作界面=====");
        System.out.println("请输入数字进行下一步操作：");
        System.out.println("0:返回商家登录界面（可登录下一个商家账号）");
        System.out.println("1:商品入库");
//        System.out.println("2:修改商品");
        System.out.println("3:删除商品");
//        System.out.println("4:清空商品");
    }

    private static void operate() {
        while (true) {
            view();//提示用户输入
            int x = MainUtil.sc.nextInt();//接收用户输入
            switch (x) {
                case 0 ://此商家操作完毕，返回到StoreSignIn.operate()，可以登录下一个商家或者退出程序
                    System.out.println("已退出当前商家账号，正在返回商家登录界面...");
                    return;
                case 1:
                    Good good = new Good();
                    System.out.println("请输入商品Id");                   //创建商品
                    good.setId(MainUtil.sc.nextInt());
                    System.out.println("请输入商品价格");
                    good.setPrice(MainUtil.sc.nextDouble());
                    System.out.println("请输入商品库存");
                    good.setStock(MainUtil.sc.nextInt());
                    System.out.println("请输入商品所属商家ID");
                    good.setStoreID(MainUtil.sc.nextInt());
                    StoreService.addGood(good);
                    break;
                    //if( ==false ){}接收返回值，false则表明此操作完毕
                case 3:
                    System.out.println("请输入需要删除的商品 id:");                   //创建商品
                    int id = MainUtil.sc.nextInt();
                    StoreService.removeGood(id);
                    break;
                case 5:
                    System.out.println("此商店下的全部商品：");
                    System.out.println("序号 id 名字 价格 库存");
                    int num = 1;
                    for (Good g : StoreService.getGoods()) {
                        System.out.println(num + " " + g.getId() + " " + g.getName() +
                                " " + g.getPrice() + " " + g.getStock());
                        num++;
                    }
                    break;
            }
        }
    }

    // 商家主页
    public static void storePage() {

        operate();

    }
}
