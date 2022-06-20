package com.fence.service;

import com.fence.pojo.Good;
import com.fence.pojo.Store;
import com.fence.utils.MainUtil;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class StoreService {

    private static final ArrayList<Store> stores = init();
    private static Store signedStore;

    public static ArrayList<Store> init() {
        Good goods1 = new Good(1001, "ThinkPad", 5000, 20, 2001);
        Good goods2 = new Good(1002, "iphone13", 7000, 100, 2001);
        Good goods3 = new Good(1003, "switch", 3000, 200, 2001);
        Good goods4 = new Good(1004, "台灯", 40, 60, 2002);
        Good goods5 = new Good(1005, "按摩椅", 2000, 3, 2002);
        Good goods6 = new Good(1006, "口罩", 1, 600, 2003);

        ArrayList<Good> goodList1 = new ArrayList<>();
        goodList1.add(goods1);
        goodList1.add(goods2);
        goodList1.add(goods3);

        ArrayList<Good> goodList2 = new ArrayList<>();
        goodList2.add(goods4);
        goodList2.add(goods5);

        ArrayList<Good> goodList3 = new ArrayList<>();
        goodList3.add(goods6);

        Store store1 = new Store(2001, "666", "电子城", goodList1, 0);
        Store store2 = new Store(2002, "666", "家具店", goodList2, 0);
        Store store3 = new Store(2003, "666", "日用百货", goodList3, 0);

        ArrayList<Store> storeList = new ArrayList<>();
        storeList.add(store1);
        storeList.add(store2);
        storeList.add(store3);

        return storeList;
    }


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

    public static String getStoreNameById(int id) {
        for (Store store : stores) {
            if (store.getId() == id) {
                return store.getName();
            }
        }
        return null;
    }

    public static Good getGoodById(int id) {
        for (Store store : stores) {
            for (Good good : store.getGoods()) {
                if (good.getId() == id) {
                    return good;
                }
            }
        }
        return null;
    }

    // 商品入库
    public static boolean addGood(Good good) {
        signedStore.getGoods().add(good);
        return true;
    }

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

    //删除某一商品
    public static boolean removeGood(int id) {
        for(int i = 0 ; i < signedStore.getGoods().size(); i++ ) {
            if(id == signedStore.getGoods().get(i).getId()) {
                Good good = signedStore.getGoods().get(i);
                signedStore.getGoods().remove(good);
                return true;
            }
        }
        return false;
    }

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