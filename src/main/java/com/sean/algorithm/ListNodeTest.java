package com.sean.algorithm;

import java.util.Stack;

public class ListNodeTest {

    public boolean isPail(ListNode head) {
        // write code here

        Stack<Integer> stack = new Stack();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }

            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(1);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNodeTest test = new ListNodeTest();
        System.out.println(test.isPail(a1));

    }
}
