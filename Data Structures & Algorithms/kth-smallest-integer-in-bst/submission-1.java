/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int count;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        count = k;
        TreeNode node = inorder(root);
        return node.val;
    }

    private TreeNode inorder(TreeNode node) {
        if (node == null) return null;

        TreeNode left = inorder(node.left);
        if (left != null) return left;

        count--;
        if (count == 0) return node;

        return inorder(node.right);
    }
}
