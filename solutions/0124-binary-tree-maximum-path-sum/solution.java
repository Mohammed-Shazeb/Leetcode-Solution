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
    int max = Integer.MIN_VALUE;;
    public int helper(TreeNode root) {
        if(root == null) return 0;

        int leftSum = Math.max(0, helper(root.left)); // take 0 when function returns -ve no.
        int rightSum = Math.max(0, helper(root.right));

        max = Math.max(max, leftSum + rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return -1;
        helper(root);
        return max;
    }
}
