package com.fence.utils;

import java.util.Scanner;

public class MainUtil {

    // 定义全局 Scanner，防止每个页面重复创建，消耗性能
    public static Scanner sc = new Scanner(System.in);


    // 打印空行 把前面的内容推上去
    public static void pBlankLine() {
        // TODO: 美化页面
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
