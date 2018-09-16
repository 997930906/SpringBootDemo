package cn.whu.test;

import java.util.Scanner;

public class ALi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int counter = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        if (n % 3 != 0){
            System.out.println(0);
        } else {
            counter = countN(n,a);
            System.out.println(counter);
        }
    }

    public static int countN(int n, int[] a){
        int counter = 0;
        boolean flag = true;
        int dis = a[0]-a[1];
        for (int i = 1; i < n-1; i++) {
            if ((a[i]-a[i+1]) != dis) {
                flag = false;
                break;
            }
        }
        if (flag) counter++;
        return counter;
    }
}
