package com.sean.algorithm;

import java.util.Arrays;

public class DynamicProgram {

    public static int countPath(int i, int j) {
        int result[][] = new int[i][j];
        for (int k = 0; k < i; k++) {
            Arrays.fill(result[k], 1); //init whole array with 1
        }
        for (int k = 1; k < i; k++) {
            for (int l = 1; l < j; l++) {
                result[k][l] = result[k - 1][l] + result[k][l - 1];
            }
        }
        return result[i - 1][j - 1];
    }

    public static void main(String[] args) {
        DynamicProgram.countPath(3, 4);
    }
}
