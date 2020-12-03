package com.sean.algorithm;

import java.util.*;

public class Tree {
    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                root = queue.poll();
                temp.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val = 1;
        TreeNode node2 = new TreeNode();
        node2.val = 2;
        node.left = node2;
        node.right = node2;

            System.out.println(Tree.levelOrder(node));
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}
