package cn.whu.xiaozhao.tencent;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int counter = 0;
        int n = in.nextInt();
        int m = in.nextInt();
        int[] u= new int[m];
        int[] v= new int[m];
        int[][] num = new int[n][n];
        for (int i = 0; i < m; i++) {
            u[i] = in.nextInt();
            v[i] = in.nextInt();

            num[u[i]-1][v[i]-1] = 1;
        }
        int x=0,y=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x += num[i][j];
                y += num[j][i];
            }
            if(y>x) counter++;
        }

        System.out.println(counter);
    }
}
