package com.sean.algorithm;

import java.util.HashMap;

public class Solution {


//    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//    你可以按任意顺序返回答案。
    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[] {i, j};
//                }
//            }
//        }
//
//        return null;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

//    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//    请你将两个数相加，并以相同形式返回一个表示和的链表。
//    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempL = new ListNode(0);
        ListNode result = tempL;
        int k = 0;
        while (l1 != null & l2 != null) {
            int temp = l1.val + l2.val + k;
            if (temp >= 10) {
                k = 1;
            } else {
                k = 0;
            }
            ListNode listNode = new ListNode(temp % 10);
            tempL.next = listNode;
            tempL = tempL.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int temp = l1.val + k;
            if (temp >= 10) {
                k = 1;
            } else {
                k = 0;
            }

            ListNode listNode = new ListNode(temp % 10);
            tempL.next = listNode;
            tempL = tempL.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int temp = l2.val + k;
            if (temp >= 10) {
                k = 1;
            } else {
                k = 0;
            }

            ListNode listNode = new ListNode(temp % 10);
            tempL.next = listNode;
            tempL = tempL.next;
            l2 = l2.next;
        }

        if (k > 0) {
            tempL.next = new ListNode(1);
        }

        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


    }
}
