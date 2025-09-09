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
    static class Info{
        int level;
        int levelSum;

        Info(int level, int levelSum){
            this.level = level;
            this.levelSum = levelSum;
        }
    }
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Info> res = new ArrayList<>();

        q.add(root);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            int levelSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();

                levelSum += curr.val;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            res.add(new Info(level, levelSum));
            level++;
        }
        // Collections.sort(res);
        res.sort((a, b) -> Integer.compare(b.levelSum, a.levelSum));
        // return res.size() -1;
        
        // if (k > levels.size()) return -1;
        return res.get(0).level;

    }
}
