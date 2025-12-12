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
    static class Info {
        int ht;
        int diam;

        Info(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static Info diameterNew(TreeNode root) {
        if (root == null)
            return new Info(0, 0);
        Info leftInfo = diameterNew(root.left);
        Info rightInfo = diameterNew(root.right);
        int diameter = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht
                + rightInfo.ht);
        int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;
        return new Info(height, diameter);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameterNew(root).diam;
    }
}
