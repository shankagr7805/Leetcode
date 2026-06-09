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
    private TreeNode bound(int[] preorder, int b, int[] a) {
        if(a[0] == preorder.length || preorder[a[0]] > b) return null;
        TreeNode root = new TreeNode(preorder[a[0]++]);
        root.left = bound(preorder, root.val, a);
        root.right = bound(preorder, b, a);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bound(preorder, Integer.MAX_VALUE, new int[]{0});
    }
}