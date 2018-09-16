package cn.whu.xiaozhao.jd;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int counter = 0;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            c[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i==j) continue;
                if (a[j] > a[i]  && b[j] > b[i] && c[j] > c[i]){
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
