package cn.whu.xiaozhao.tencent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int m = n; m < 1000; m++) {

            if (testLCM(0,n) ==testLCM(n,m)){
                System.out.println(m);
                break;
            }
        }
       // testLCM();
    }

    public static int testLCM(int n,int m) {
        int result = 0;
        int tem;
        boolean flag = true;
        while (flag){
            for (int i = 1; i < 100; i++) {
                tem = i*m;
                for (int j = n; j <= m; j++) {
                    if(tem % j ==0){
                        if (j==m) {
                            flag = false;
                        }
                        continue;
                    } else {

                        break;
                    }
                }

                if(!flag) break;
            }

        }

        return result;
    }

 }
