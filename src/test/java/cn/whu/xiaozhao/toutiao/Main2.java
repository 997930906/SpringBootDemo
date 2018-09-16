package cn.whu.xiaozhao.toutiao;

import java.util.Scanner;

public class Main2 {
    public static int getCounter(int[][] a,int M){
        int counter = 0;
        int[][] b = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j]==0 || b[i][j] == 1) {
                    continue;
                } else {

                    counter++;
                    for (int k = j; k < M; k++) {
                        if (a[i][k] == 1) {
                            b[i][k] = 1;
                            for (int l = i; l < M; l++) {
                                if (a[l][k] == 1) {
                                    b[l][k] = 1;
                                } else break;
                            }
                            for (int n = k; n > 0; n--) {
                                if (a[n][k] == 1){
                                    b[n][k] = 1;
                                } else {
                                    break;
                                }
                            }
                        } else break;
                    }

                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int[][] a =  new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int counter = getCounter(a,M);
        System.out.println(counter);
    }
}
