package cn.whu.xiaozhao;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][2];
        int[][] b = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i][0] = 0;
            //b[i][1] = getR(a[i][1]);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(0);
            System.out.print(b[i][1]);
            //System.out.println(a[i][0]+","+a[i][1]);
        }


    }
}
