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
    public static void inorder(TreeNode root, ArrayList<Integer>inorder){
        if(root == null) return;

        inorder(root.left,inorder);
        inorder.add(root.val);
        inorder(root.right,inorder);
    }

    public static TreeNode buildBst(ArrayList<Integer> inorder, int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(inorder.get(mid));

        root.left = buildBst(inorder, left, mid - 1);
        root.right = buildBst(inorder, mid + 1, right);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        //inorder
        inorder(root, inorder);

        // arrayList(sorted) -> bst 
        return buildBst(inorder, 0, inorder.size() - 1);
    }
}
