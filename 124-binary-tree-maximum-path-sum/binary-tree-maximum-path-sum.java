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
    private int maxPath(TreeNode root, int[] maxi) {
        if(root == null) return 0;
        int l = Math.max(0, maxPath(root.left, maxi));
        int r = Math.max(0, maxPath(root.right, maxi));
        maxi[0] = Math.max(maxi[0], root.val + l + r);
        return Math.max(l, r) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxPath(root, maxi);
        return maxi[0];
    }
}