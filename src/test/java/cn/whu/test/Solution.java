package cn.whu.test;
/*
<LeetCode>121. 买卖股票的最佳时机
题目：
假设你有一个数组，其中第 i 个元素是一支给定股票第 i 天的价格。
如果您只能完成最多一笔交易（即买入和卖出一股股票），则设计一个算法来找到最大的利润。
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices ={7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

    }
    public static int maxProfit(int[] prices){
        int buy = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i<prices.length;i++){
            buy = Math.min(prices[i], buy);
            result = Math.max(result, prices[i] - buy);
        }
        return result;
    }

}
