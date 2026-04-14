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
    private int depth(TreeNode node) {
        if(node == null) return 0;
        
        int l = depth(node.left);
        if (l == -1) return -1;

        int r = depth(node.right);
        if (r == -1) return -1;

        if(Math.abs(l-r) > 1) return -1;
        return 1 + Math.max(l,r) ;
    }
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
}