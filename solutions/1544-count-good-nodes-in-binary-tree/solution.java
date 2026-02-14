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
    private int count = 0;

    public int helper(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        if (root.val >= max)
            count++;

        int rootLeft = helper(root.left, Math.max(root.val, max));
        int rootRight = helper(root.right, Math.max(root.val, max));

        return count;
    }

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root, root.val);
    }
}
