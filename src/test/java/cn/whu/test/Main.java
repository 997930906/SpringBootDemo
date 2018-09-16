package cn.whu.test;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums){
        int n = nums[0];

        for (int i=1; i<nums.length;i++){
            n ^= nums[i]; //异或
        }
        return n;
    }
}
