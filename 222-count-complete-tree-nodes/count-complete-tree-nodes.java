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
    private int left_h(TreeNode root) {
        int t = 0;
        while(root != null) {
            t++;
            root = root.left;
        }
        return t;
    }
    private int right_h(TreeNode root) {
        int t = 0;
        while(root != null) {
            t++;
            root = root.right;
        }
        return t;
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = left_h(root);
        int rh = right_h(root);
        if(lh == rh) return (1 << lh) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}