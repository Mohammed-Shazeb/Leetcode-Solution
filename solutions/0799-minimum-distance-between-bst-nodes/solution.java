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
    int ans = Integer.MAX_VALUE;
    int val = -1;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return ans;
            
        minDiffInBST(root.left);
        if (val != -1)
            ans = Math.min(ans, root.val - val);
        val = root.val;
        minDiffInBST(root.right);
        return ans;
    }
}
