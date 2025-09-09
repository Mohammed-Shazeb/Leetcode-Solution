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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Long> res = new ArrayList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            long size = q.size(); // Number of nodes at current level
            long maxSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                maxSum += curr.val;

                if (curr.left != null)q.add(curr.left);
                if (curr.right != null)q.add(curr.right);
            }

            res.add(maxSum); // store total sum of current level
        }
        Collections.sort(res);
        if(k > res.size()) return -1;
        long result = res.get(res.size() - k);
        return result;

    }
}
