package cn.whu.test;

public class LCSequence {
    public static int LCS(String X, String Y){
        int[][] c = new int[X.length()+1][Y.length()+1];
        for (int i = 0; i <= X.length(); i++) {//x为空时初始化
            c[i][0] = 0;
        }
        for (int i = 0; i <= Y.length(); i++) {
            c[0][i] = 0;
        }

        for (int i = 1; i <= X.length(); i++) {
            for (int j = 1; j <= Y.length(); j++) {

                if (X.charAt(i-1) == Y.charAt(j-1))
                    c[i][j] = c[i-1][j-1] + 1;
                else if ( c[i-1][j] > c[i][j-1])
                    c[i][j] = c[i-1][j];
                else
                    c[i][j] = c[i][j-1];
            }
        }
        return c[X.length()][Y.length()];

    }

    public static void main(String[] args) {
        String str1 = "BDCABA";
        String str2 = "ABCBDAB";
        int result = LCS(str1, str2);
        System.out.println(result);
    }
}
