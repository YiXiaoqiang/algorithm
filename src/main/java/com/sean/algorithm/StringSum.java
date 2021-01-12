package com.sean.algorithm;

import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

public class StringSum {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        // write code here
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        char[] result = new char[Math.max(a.length,b.length) + 1];

        int rIndex = result.length - 1;
        int aIndex = a.length -1;
        int bIndex = b.length -1;

        int carry = 0;

        while(aIndex >= 0 && bIndex >= 0){
            int A = a[aIndex--] - '0';
            int B = b[bIndex--] - '0';
            result[rIndex--] = (char)((A + B + carry)%10 + '0');
            carry = (A + B + carry)/10;
        }

        while(aIndex>=0){
            int A = a[aIndex--] - '0';
            result[rIndex--] = (char)((A + carry)%10 + '0');
            carry = (A + carry)/10;
        }

        while(bIndex>=0){
            int B = b[bIndex--] - '0';
            result[rIndex--] = (char)((B + carry)%10 + '0');
            carry = (B + carry)/10;
        }

        if(carry!=0){
            result[rIndex] = (char)(carry + '0');
            return String.valueOf(result);
        }
        return String.valueOf(result).substring(1);
    }

    public static void main(String[] args) {
        StringSum stringSum = new StringSum();
        System.out.println(stringSum.solve("0", "0"));
    }
}
