package com.sean.algorithm;

public class ReverseList {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}

