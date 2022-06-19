package com.fence.views.userViews;

import com.fence.pojo.User;
import com.fence.service.UserService;
import com.fence.utils.MainUtil;

// TODO: 余戬
public class UserSignIn {

    private static void view() {
        MainUtil.pBlankLine();
        System.out.println("---登录页---");
        System.out.println("请输入账号和密码:123 123");
    }

    private static void operate() {
        System.out.println("账号:");
        int id = MainUtil.sc.nextInt();
        MainUtil.sc.nextLine();
        System.out.println(id);
        System.out.print("密码:");
        String password = MainUtil.sc.nextLine();
        boolean login = UserService.login(id, password);
        if (login) {
            UserPage.userPage();
        } else {
            System.out.println("账号或密码错误");
        }
    }

    // 登录
    public static void signIn() {

        view();
        operate();

    }

}
