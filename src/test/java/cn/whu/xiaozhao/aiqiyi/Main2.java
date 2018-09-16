package cn.whu.xiaozhao.aiqiyi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        int counter = 0;
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int P = in.nextInt();
        int[] A = new int[N];
        String[] b = new String[M];
        int[] c = new int [M];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            b[i] = in.next();
            c[i] = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            if(b[i].equals("A")){
                A[c[i]-1]++;
            } else {
                A[c[i]-1]--;
            }
        }
        int num = A[P-1];

        Arrays.sort(A);
        for (int i = 0; i < A.length/2; i++) {

            int tem = A[i];
            A[i] = A[A.length-i-1];
            A[A.length-i-1] = tem;
        }

        for (int i = 0; i <A.length ; i++) {
            if(num == A[i]){
                counter = i;
            }
        }
        System.out.println(counter);

    }
}
