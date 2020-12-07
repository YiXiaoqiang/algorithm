package com.sean.algorithm;

import java.util.HashMap;

public class MaxLength {


    //给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
    public int maxLength (int[] arr) {
        // write code here

        HashMap<Integer, Integer> index = new HashMap<>();
        int temp = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (index.get(arr[i]) != null) {
                temp = Math.max(temp, index.get(arr[i]) + 1);
            }
            index.put(arr[i], i);

            result = Math.max(result, i - temp + 1);
        }
        return result;
    }
}
