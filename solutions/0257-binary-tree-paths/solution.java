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
    public void helper(TreeNode root, List<String> res, StringBuilder sb) {
        if(root == null) return;
        int len = sb.length();

        sb.append(Integer.toString(root.val));

        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        sb.append("->");
        helper(root.left, res, sb);
        helper(root.right, res, sb);

        sb.setLength(len);   // this do this "1->2->5->" → "1->2->"
    }
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        List<String> res = new ArrayList<>();
        helper(root, res, sb);
        return res;
    }
}
