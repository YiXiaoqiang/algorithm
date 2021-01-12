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


    public ListNode revert(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        ReverseList reverseList = new ReverseList();
        reverseList.ReverseList(a1);
    }
}

