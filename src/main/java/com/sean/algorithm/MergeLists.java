package com.sean.algorithm;

public class MergeLists {

    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode temp = result;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        }

        if (l2 != null) {
            temp.next = l2;
        }

        return result.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode next = new ListNode(4);
        l1.next = next;
        MergeLists.mergeTwoLists(l1, new ListNode(3));

    }
}
