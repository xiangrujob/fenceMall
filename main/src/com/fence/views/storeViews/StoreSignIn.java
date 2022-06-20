package com.fence.views.storeViews;

import com.fence.service.StoreService;
import com.fence.utils.MainUtil;
import com.fence.views.Index;

public class StoreSignIn {

    private static void view() {
        //交互提示语
        System.out.println("=====商家登录界面=====");
        System.out.println("请输入数字获取操作：");
        System.out.println("0: 返回主页");
        System.out.println("1: 商家登录");
    }

    private static void operate() {

        while (true) {
            view();//提示用户输入
            int a = MainUtil.sc.nextInt();//接收用户输入
            switch (a) {//确定是否为商家
                case 0://不是商家，返回主页
                    return;
                case 1://是商家，继续登录
                    break;
            }

        System.out.println("请输入您的账号（ID）和密码：");
        int id = MainUtil.sc.nextInt();
        String password = MainUtil.sc.next();
        //if(){}接收StoreService登录方法的返回值，判断登陆是否成功
        StoreService.login(id, password);
        StorePage.storePage();//若登陆成功，进入商家主页

        }

    }

    // 登录
    public static void signIn() {

        operate();

    }

}
