package com.sean.algorithm;

public class JumpFloor {

    //一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
    public static int JumpFloor(int target) {
        int[] dp = new int[target + 1];
        if (target == 1) return 1;
        if (target == 2) return 2;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    //对于第n个台阶来说，只能从n-1或者n-2的台阶跳上来

    public static void main(String[] args) {
        System.out.println(JumpFloor.JumpFloor(4));
        int i = 1;
        int j = 2;
        int[] a = new int[] {i, j};

    }
}
