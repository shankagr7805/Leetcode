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
    int maxi = Integer.MIN_VALUE;
    private int maxPath(TreeNode root) {
        if(root == null) return 0;
        int l = Math.max(0, maxPath(root.left));
        int r = Math.max(0, maxPath(root.right));
        maxi = Math.max(maxi, root.val + l + r);
        return Math.max(l, r) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxi;
    }
}