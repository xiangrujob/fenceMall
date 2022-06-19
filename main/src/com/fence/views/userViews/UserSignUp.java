package com.fence.views.userViews;

import com.fence.service.UserService;
import com.fence.utils.MainUtil;

// TODO: 余戬
public class UserSignUp {

    private static void view() {
        System.out.println("---注册页---");

        System.out.println("请输入新的账号和新的密码：");

    }

    private static void operate() {
        System.out.println("请输入你的新账号：");
        String user=MainUtil.sc.nextLine();
        System.out.println("请输入你的新密码：");
        String password=MainUtil.sc.nextLine();
        boolean login = UserService.login(user);
        if (login) {
            UserSignIn.signIn();
        } else {
            System.out.println("注册失败");
        }
    }


    // 注册
    public static void signUp() {
        view();
        operate();
    }
}
