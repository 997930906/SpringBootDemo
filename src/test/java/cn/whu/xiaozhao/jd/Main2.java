package cn.whu.xiaozhao.jd;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        int lena, lenb;

        Scanner in = new Scanner(System.in);
        String as = in.next();
        String bs = in.next();
        lena = as.length();
        lenb = bs.length();
        char a[] = new char[lena];
        char b[] = new char[lenb];
        a = as.toCharArray();
        b = bs.toCharArray();
        int[][] dp = new int[1010][1010];
        for(int i=1; i<=lena; i++) dp[i][0] = i;
        for(int j=1; j<=lenb; j++) dp[0][j] = j;
        for(int i=1; i<=lena; i++)
            for(int j=1; j<=lenb; j++)
                if(a[i-1]==b[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
        System.out.println(dp[lena][lenb]);
    }
}
