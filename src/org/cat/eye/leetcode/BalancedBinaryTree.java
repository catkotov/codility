package org.cat.eye.leetcode;

public class BalancedBinaryTree {

    private static int height(TreeNode root) {

        if (root == null) {
            return -1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        return Math.abs(height(root.right) - height(root.left)) < 2
                && isBalanced(root.left) && isBalanced(root.right);
    }

}
