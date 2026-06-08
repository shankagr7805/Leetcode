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
    int cnt = 0; int res = -1;
    private void in(TreeNode root, int k) {
        if(root == null || res!= -1) {
            return;
        }
        in(root.left, k);
        cnt++;
        if(cnt == k) {
            res = root.val;
            return;
        }
        in(root.right, k);
        return;
    }
    public int kthSmallest(TreeNode root, int k) {
        in(root, k);
        return res;
    }
}