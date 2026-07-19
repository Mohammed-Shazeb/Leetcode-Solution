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
    int res = Integer.MIN_VALUE;
    public int helper(TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left); // take 0 when function returns -ve no.
        int right = helper(root.right);

        int temp = Math.max(Math.max(left, right) + root.val, root.val);

        int ans = Math.max(temp, left+right+root.val);

        res = Math.max(ans, res);
        return temp;
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return res;

        // if(root == null) return 0;

        // int left = maxPathSum(root.left); // take 0 when function returns -ve no.
        // int right = maxPathSum(root.right);

        // int temp = Math.max(Math.max(left, right) + root.val, root.val);

        // int ans = Math.max(temp, left+right+1);
        // int res = Integer.MIN_VALUE;
        // res = Math.max(ans, res);
        // return temp;
    }
}
