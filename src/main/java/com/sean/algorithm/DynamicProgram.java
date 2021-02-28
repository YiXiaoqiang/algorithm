package com.sean.algorithm;

import java.util.Arrays;

public class DynamicProgram {

    public static int countPath(int m, int n) {
//        int result[][] = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            Arrays.fill(result[i], 1);
//        }
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                result[i][j] = result[i - 1][j] + result[i][j - 1];
//            }
//        }
//        return result[m - 1][n - 1];

        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int j = 1; j < n; j++)
            for (int i = 1; i < m; i++)
                dp[i] += dp[i - 1];
        return dp[m - 1];
    }

    //    给你一个字符串 s，找到 s 中最长的回文子串。
    public String longestPalindrome(String s) {
        char c[] = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
        }

        return null;

    }

    public static void main(String[] args) {
        DynamicProgram.countPath(3, 4);
    }
}
