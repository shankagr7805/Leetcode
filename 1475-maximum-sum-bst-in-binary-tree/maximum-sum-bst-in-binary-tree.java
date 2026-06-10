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
class Node {
    public int max, min, sum;

    Node(int max, int min, int sum) {
        this.max = max;
        this.min = min;
        this.sum = sum;
    }
}
class Solution {
    int ans = 0;
    private Node helper(TreeNode root) {
        if(root == null) return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        Node left = helper(root.left);
        Node right = helper(root.right);

        if(left.max < root.val && right.min > root.val) {
            ans = Math.max(ans, left.sum + right.sum + root.val);
            return new Node(Math.max(root.val, right.max), Math.min(root.val, left.min), left.sum + right.sum + root.val);
        }
        return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }
    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }
}