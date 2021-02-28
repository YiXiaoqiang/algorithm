package com.sean.algorithm;

import java.util.LinkedList;
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

    public ListNode FindKthToTail(ListNode head, int k) {
//        List<ListNode> list = new ArrayList<>();
//
//        while (head != null) {
//            ListNode node = head;
//            list.add(node);
//            head = head.next;
//        }
//
//        if (k > list.size() || k < 1) return null;
//        return list.get(list.size() - k);

        ListNode p, q;
        for (p = q = head; p != null; p = p.next, k--){
            if (k <= 0) {
                q = q.next;
            }
        }
        return k <= 0 ? q : null;
    }

    public ListNode sortInList (ListNode head) {
        // write code here
        while (head != null) {
            ListNode base =  head;
            ListNode p = head.next;
            while (p != null) {
                if (base.val > p.val) {
                    base = p;
                }
                p = p.next;
            }

            int temp = head.val;
            head.val = base.val;
            base.val = temp;
            head = head.next;
        }

        return null;
    }

//    给出两个有序的整数数组 A和 B，请将数组B 合并到数组A 中，变成一个有序的数组
//    注意：
//    可以假设A 数组有足够的空间存放B 数组的元    素，A 和B 中初始的元素数目分别为m 和n
    public void merge(int A[], int m, int B[], int n) {
        int indexA = m - 1;
        int indexB = n -1;
        int index = m + n -1;

        while (indexA >= 0 && indexB >= 0) {
            A[index--] = A[indexA] > B[indexB] ? A[indexA--] : B[indexB--];
        }

        while (indexB>=0) {
            A[index--] = B[indexB--];
        }
    }
//     <删除链表的倒数第n个结点>
//    给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
//    例如，
//    给出的链表为:1->2->3->4->5, n= 2.
//    删除了链表的倒数第n个节点之后,链表变为1->2->3->5.
//    备注：
//    题目保证n一定是有效的
//    请给出请给出时间复杂度为\ O(n) O(n)的算法
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode p, q;
        n = n + 1;
        for (p = q = head; p != null; p = p.next, n--){
            if (n <= 1) {
                q = q.next;
            }
        }

        if (n <= 1) {

        }

        return null;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNodeTest test = new ListNodeTest();
//        System.out.println(test.isPail(a1));
        test.FindKthToTail(a1, 2);

    }
}
