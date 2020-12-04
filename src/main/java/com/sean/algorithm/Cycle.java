package com.sean.algorithm;

public class Cycle {

    //判断给定的链表中是否有环。如果有环则返回true，否则返回false。
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
    /*
        链表有环思路：如果有环，设置一个快指针，设置一个慢指针，
        快指针一次走两步，慢指针一次走一步，快指针总能追上慢的
        */
}


