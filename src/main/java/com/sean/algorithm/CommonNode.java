package com.sean.algorithm;

public class CommonNode {

//    输入两个链表，找出它们的第一个公共结点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }

//    大概意思应该是 如果两个链表不等长  那么一边长的和短的都走一遍 那么就是等长了 那遇到相等的点自然就返回值了。
//            1 2 3 4 5 || 6 4 5
//            6 4 5 || 1 2 3 4 5

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode b1 = new ListNode(11);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        b1.next = a3;

        CommonNode commonNode = new CommonNode();
        System.out.println(commonNode.FindFirstCommonNode(a1, b1));
    }
}
