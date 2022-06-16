package com.fence.views;

import com.fence.utils.MainUtil;
import com.fence.views.storeViews.StorePage;
import com.fence.views.storeViews.StoreSignIn;
import com.fence.views.userViews.UserPage;
import com.fence.views.userViews.UserSignIn;

/*
主页
*/
public class Index {

    private static void view() {
        MainUtil.pBlankLine();
        System.out.println("欢迎您使用本程序！");
        System.out.println("0: 退出");
        System.out.println("1: 用户登录");
        System.out.println("2: 商户登录");

    }

    private static void operate() {
        while (true) {
            if (MainUtil.sc.hasNext()) {
                int next = MainUtil.sc.nextInt();
                switch (next) {
                    case 0: // 退出应用
                        System.out.println("Bye!");
                        return;
                    case 1: // 选择用户
                        UserSignIn.signIn();
                    case 2: // 选择商户
                        StoreSignIn.signIn();

                }
            }
        }
    }

    public static void index() {
//        Runner wait = new Runner("index:", i);
//        Thread thread1 = new Thread(wait);
//        thread1.start();
        view();
        operate();

    }
}

//class Runner implements Runnable {
//    private final String threadName;
//    private final int num;
//
//    Runner(String name, int num) {
//        threadName = name;
//        this.num = num;
//        System.out.println("Creating " +  threadName + num);
//    }
//
//    public void run() {
//        System.out.println("Running " +  threadName + num);
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            if (scanner.hasNext()) {
//                int next = scanner.nextInt();
//                System.out.println(next);
//                if (next == 0) {
//                    System.out.println("end");
//                    Index.index(num + 1);
//                    return;
//                }
//            }
//        }
//    }
//}
