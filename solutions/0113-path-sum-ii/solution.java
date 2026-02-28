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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<Integer> path = new ArrayList<>();
        helper(root, targetSum, 0, path);
        return res;
    }

    private void helper(TreeNode root, int target, int sum, List<Integer> path) {
        if (root == null)
            return;


        path.add(root.val);    
        sum += root.val;

        if (sum == target && root.left == null && root.right == null)
            res.add(new ArrayList<>(path));

        helper(root.left, target, sum, path);
        helper(root.right, target, sum, path);
    
        path.remove(path.size() - 1);
    }
}

