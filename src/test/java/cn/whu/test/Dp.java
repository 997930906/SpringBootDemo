package cn.whu.test;

/**
 * 最长递增子序列
 */
public class Dp {

    public static int LIS(int[] A){
        int result = 1;
        int[] B = new int[A.length];         //存放每一个节点的LIS
        for (int i = 0; i < B.length; i++) { //初始化
            B[i] = 1;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j =0; j < i; j++){
                if(A[j] < A[i]){
                    B[i] = Math.max(B[i], B[j]+1);
                }
            }
            result = Math.max(result, B[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(LIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
