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
    
      public static int height(TreeNode root) {
        if (root == null)
            return 0;

        int lf = height(root.left);
        int rf = height(root.right);
        return Math.max(lf, rf) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
         if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        int selfDiameter = lh + rh;
        int res = Math.max(selfDiameter, Math.max(ld, rd));
        return res;
    }
}
