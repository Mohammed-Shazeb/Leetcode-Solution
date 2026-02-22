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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inOrderMap);
    }

    private TreeNode buildTree(int[] postorder, int postStart, int postEnd,
                        int[] inorder, int inStart, int inEnd, 
                        Map<Integer, Integer> inOrderMap) {
        if (postStart > postEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = inOrderMap.get(root.val); // get the root index in O(1) 
        int numsLeft = inRoot - inStart; // this gives number of left nodes in the tree from the inorder[]

        root.left = buildTree(postorder, postStart, postStart + numsLeft - 1, inorder, inStart, inRoot - 1, inOrderMap);
        root.right = buildTree(postorder, postStart + numsLeft, postEnd - 1, inorder, inRoot + 1, inEnd, inOrderMap);

        return root;
    }
}
