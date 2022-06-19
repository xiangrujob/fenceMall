package com.fence.service;

import com.fence.pojo.Good;
import com.fence.pojo.Store;
import com.fence.utils.MainUtil;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;


// TODO: 三少爷
public class StoreService {

    private static final ArrayList<Store> stores = init();
    private static Store signedStore;

    public static ArrayList<Store> init() {
        Good goods1 = new Good(1001, 10, 20, 2001);
        Good goods2 = new Good(1002, 10, 30, 2001);
        Good goods3 = new Good(1003, 10, 40, 2001);
        Good goods4 = new Good(1004, 10, 30, 2002);
        Good goods5 = new Good(1005, 10, 50, 2002);
        Good goods6 = new Good(1006, 10, 70, 2003);

        ArrayList<Good> goodList1 = new ArrayList<>();
        goodList1.add(goods1);
        goodList1.add(goods2);
        goodList1.add(goods3);

        ArrayList<Good> goodList2 = new ArrayList<>();
        goodList2.add(goods4);
        goodList2.add(goods5);

        ArrayList<Good> goodList3 = new ArrayList<>();
        goodList3.add(goods6);

        Store store1 = new Store(2001, "666", "store1", goodList1, 0);
        Store store2 = new Store(2002, "666", "store2", goodList2, 0);
        Store store3 = new Store(2003, "666", "store3", goodList3, 0);

        ArrayList<Store> storeList = new ArrayList<>();
        storeList.add(store1);
        storeList.add(store2);
        storeList.add(store3);

        return storeList;

    }


//    遍历思路：
//    for循环遍历商家列表stores
//        1.商家存在：
//            1)商品存在，则对商品进行操作
//            2)商品不存在
//        2.商家不存在：即商品不存在


    public static boolean login(int id, String password) {
        for (Store store : stores) {
            if (store.getId() == id) {
                if (store.getPassword().equals(password)) {
                    signedStore = store;
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Good> getAllGoods() {
        ArrayList<Good> goodList = new ArrayList<>();
        for (Store store : stores) {
            for (Good good : store.getGoods()) {
                goodList.add(good);
            }
        }
        return goodList;
    }

    public static List<Good> getGoods() {
        return signedStore.getGoods();
    }

    // 商品入库
    public static boolean addGood(Good good) {

        signedStore.getGoods().add(good);
        return true;


//        for (int i = 0; i < stores.size(); i++) {
//            if (store.getId() == stores.get(i).getId()) {                //商家存在
//            if (!(good.getStoreID() == stores.get(i).getId())) {        //商品不在对应商家中(即商品不存在)

//        stores.get(i).getGoods().add(good);                 //将新商品添加入库对应商家
//                }
//            }
//        else {                                                      //商家不存在
//
//                System.out.println("商家不存在！");
//
//                System.out.println("请输入商家id");                      //创建新商家
//                store.setId(MainUtil.sc.nextInt());
//
//                System.out.println("请输入商家名称");
//                store.setName(MainUtil.sc.next());
//
//                System.out.println("请输入商家商品序列");
//                store.setGoods(new ArrayList<>());
//
//                System.out.println("请输入商家营业额");
//                store.setEarnPrice(MainUtil.sc.nextDouble());
//
//
//                System.out.println("请输入商品id");                      //创建商品
//                good.setId(MainUtil.sc.nextInt());
//
//                System.out.println("请输入商品价格");
//                good.setPrice(MainUtil.sc.nextDouble());
//
//                System.out.println("请输入商品库存");
//                good.setStock(MainUtil.sc.nextInt());
//
//                System.out.println("请输入商品所属商家id");
//                good.setStoreID(MainUtil.sc.nextInt());
//
//                stores.add(store);
//
//                store.getGoods().add(good);                             //将新商品添加入库新商家
//            }
//            return true;
//        }
//        return false;
    }


// 修改商品（要扩展成多个方法）:
    // 修改商品Id(modifyGoodId)
    // 修改商品价格(modifyGoodPrice)
    // 修改商品库存（modifyGoodStock）
    // 增加商品库存(addGoodStock)
    // 修改商品所属商家ID(modifyGoodStoreID)

    //修改商品Id
    public static boolean modifyGoodId(Store store, Good good) {
        for (int i = 0; i < stores.size(); i++) {
            if (store.getId() == stores.get(i).getId()) {                  //商家存在
                if (good.getStoreID() == stores.get(i).getId()) {          //商品在对应商家中

                    System.out.println("请输入商品id");
                    good.setId(MainUtil.sc.nextInt());                     //修改商品Id
                    return true;                                           //修改成功，返回true

                } else {
                    System.out.println("商品不在该商家中!");
                    return false;                                          //商品不存在，返回false
                }
            } else {
                System.out.println("商家不存在！");
                return false;                                              //商家不存在，返回false
            }
        }
        return false;
    }


    //修改商品价格
    public static boolean modifyGoodPrice(Store store, Good good) {
        for (int i = 0; i < stores.size(); i++) {
            if (store.getId() == stores.get(i).getId()) {                  //商家存在
                if (good.getStoreID() == stores.get(i).getId()) {          //商品在对应商家中

                    System.out.println("请输入商品价格：");
                    good.setPrice(MainUtil.sc.nextDouble());               //修改商品价格
                    return true;                                           //修改成功，返回true

                } else {
                    System.out.println("商品不在该商家中！");
                    return false;                                          //商品不存在，返回false
                }
            } else {
                System.out.println("商品不存在");
                return false;                                              //商家不存在，返回false
            }
        }
        return false;
    }

    //修改商品库存
    public static boolean modifyGoodStock(Store store, Good good) {
        for (int i = 0; i < stores.size(); i++) {
            if (store.getId() == stores.get(i).getId()) {                   //商家存在
                if (good.getStoreID() == stores.get(i).getId()) {          //商品在对应商家中

                    System.out.println("请输入商品库存：");
                    good.setStock(MainUtil.sc.nextInt());                  //修改商品库存Stock
                    return true;                                           //修改成功，返回true

                } else {
                    System.out.println("商品不在该商家中！");
                    return false;                                          //商品不存在，返回false
                }
            } else {
                System.out.println("商家不存在！");
                return false;                                              //商家不存在，返回false
            }
        }
        return false;
    }

    //增加商品库存
    public static boolean addGoodStock(Store store, Good good) {
        for (int i = 0; i < stores.size(); i++) {
            if (store.getId() == stores.get(i).getId()) {                   //商家存在
                if (good.getStoreID() == stores.get(i).getId()) {          //商品在对应商家中

                    System.out.println("请输入新增商品数量：");
                    int count = MainUtil.sc.nextInt();                     //输入新增商品数
                    good.setStock(good.getStock() + count);                //加入库存
                    return true;                                           //修改成功，返回true

                } else {
                    System.out.println("商品不在该商家中");
                    return false;                                          //商品不存在，返回false
                }
            } else {
                System.out.println("商家不存在！");
                return false;                                              //商家不存在，返回false
            }
        }
        return false;
    }

    //修改商品所属商家ID
    public static boolean modifyGoodStoreID(Store store, Good good) {
        for (int i = 0; i < stores.size(); i++) {
            if (store.getId() == stores.get(i).getId()) {                   //商家存在
                if (good.getStoreID() == stores.get(i).getId()) {          //商品在对应商家中

                    System.out.println("请输入商品所属商家id：");
                    good.setStoreID(MainUtil.sc.nextInt());                //修改商品所属商家ID
                    return true;                                           //修改成功，返回true

                } else {
                    System.out.println("商品不在该商家中！");
                    return false;                                          //商品不存在，返回false
                }
            } else {
                System.out.println("商家不存在！");
                return false;                                              //商家不存在，返回false
            }
        }
        return false;
    }

//    // 删除商品
//    // TODO: 新功能
//    public static boolean deleteGood(Good good) {
//        for (int i = 0; i < stores.size(); i++) {
//            if (store.getId() == stores.get(i).getId()) {                   //商家存在
//                if (good.getStoreID() == stores.get(i).getId()) {          //商品在对应商家中
//
//                    stores.get(i).getGoods().remove(good);                 //删除商品
//                    System.out.println("已删除该商品");
//                    return true;                                           //删除成功，返回true
//
//                } else {
//                    System.out.println("商品不在该商家中，无需删除");
//                    return true;                                          //商品不存在，返回true
//                }
//            } else {
//                System.out.println("商家不存在！");
//                return true;                                              //商家不存在，返回true
//            }
//        }
//        return false;
//    }

//    // 清空商品
//    // TODO: 新功能
//    public static boolean clearGoods(Store store) {
//        for (int i = 0; i < stores.size(); i++) {
//            if (store.getId() == stores.get(i).getId()) {                  //商家存在
//
//                stores.get(i).getGoods().clear();                         //清空商品
//                System.out.println("该商家的商品已清空");
//                return true;
//
//            } else {                                                       //商家不存在
//                System.out.println("商家不存在,无需此操作");
//                return true;
//            }
//        }
//        return false;
//    }

    public static boolean sellGood(Good good) {

        for (Store store : stores) {
            if (store.getId() == good.getStoreID()) {
                for (int i = 0; i < store.getGoods().size(); i++) {
                    if (store.getGoods().get(i).getId() == good.getId()) {
                        store.getGoods().get(i).setStock(store.getGoods().get(i).getStock() - 1);
                        store.setEarnPrice(store.getEarnPrice() + store.getGoods().get(i).getPrice());
                        if (store.getGoods().get(i).getStock() == 0) {
                            store.getGoods().remove(i);
                        }
                    }
                }
            }
        }
        return true;
    }

}