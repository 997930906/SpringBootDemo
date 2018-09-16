package cn.whu.xiaozhao.toutiao;

import java.util.Scanner;

public class Main3 {
    public static int getIpNum(String ip){
        int result = 0;
        int len = ip.length();
        if(len == 4 || len == 12) result = 1;

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.next();
        int ipNumber = getIpNum(ip);
        System.out.println(ipNumber);
    }
}
