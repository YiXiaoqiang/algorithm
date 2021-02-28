package com.sean.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Nomura {

    public static int getNumberBySplitStr(String str) {
        char[] c = str.toCharArray();
        List<Integer> aList = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'a') {
                aList.add(i);
            }
        }
        if (aList.size() % 3 != 0) {
            return 0;
        }
        if (aList.size() == 0) {
            return c.length + 1;
        }
        int singeA = aList.size() / 3;
        int first = singeA - 1;
        int middleLeft = singeA;
        int middleRight = singeA * 2 - 1;
        int last = singeA * 2;

        return (aList.get(middleLeft) - aList.get(first)) * (aList.get(last) - aList.get(middleRight));
    }

    public static int[] ten2two(int n) {
        int result[] = new int[30];
        int index = 0;
        while (n > 0) {
            result[index] = n % 2;
            n /= 2;
            index++;
        }

        return result;
    }

    public static int maxSumTwoNoOverlap(int[] A, int l, int m) {
        int n = A.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + A[i - 1];

        int res = 0;
        for (int i = 1, j = l + 1, left = 0; j + m - 1 <= n; i++, j++) {
            left = Math.max(left, sum[i + l - 1] - sum[i - 1]);
            res = Math.max(left + sum[j + m - 1] - sum[j - 1], res);
        }
        for (int i = 1, j = m + 1, left = 0; j + l - 1 <= n; i++, j++) {
            left = Math.max(left, sum[i + m - 1] - sum[i - 1]);
            res = Math.max(left + sum[j + l - 1] - sum[j - 1], res);
        }
        return res;
    }


    public String longestDiverseString(int a, int b, int c) {
        MyChar[] myChars = new MyChar[]{
                new MyChar('a', a),
                new MyChar('b', b),
                new MyChar('c', c),
        };
        StringBuilder sb = new StringBuilder();
        while (true) {
            Arrays.sort(myChars);
            //先放最多的, 如果上个放的2个字符串和剩余个数最多的字符相同，则放置次多的字符
            if (sb.length() >= 2 &&
                    sb.charAt(sb.length() - 1) == myChars[2].ch &&
                    sb.charAt(sb.length() - 2) == myChars[2].ch) {
                if (myChars[1].count-- > 0) {
                    sb.append(myChars[1].ch);
                } else {
                    break;
                }
            } else {
                if (myChars[2].count-- > 0) {
                    sb.append(myChars[2].ch);
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }

    private class MyChar implements Comparable {
        char ch;
        int count;

        public MyChar(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(Object o) {
            MyChar other = (MyChar) o;
            return this.count - other.count;
        }
    }

    public static void main(String[] args) {
        Nomura nomura = new Nomura();
        nomura.longestDiverseString(6, 2, 3);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("");
    }
}
