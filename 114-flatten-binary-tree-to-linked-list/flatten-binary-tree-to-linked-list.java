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
    private void preOrder(TreeNode root, List<TreeNode> pre) {
        if(root == null) return;  
        pre.add(root);
        preOrder(root.left, pre);
        preOrder(root.right, pre);
    }
    public void flatten(TreeNode root) {
        if(root == null) return;
        List<TreeNode> pre = new ArrayList<>();
        preOrder(root, pre);
        
        for(int i=0; i<pre.size()-1; i++) {
            pre.get(i).left = null;
            pre.get(i).right = pre.get(i+1);
        }
    }
}