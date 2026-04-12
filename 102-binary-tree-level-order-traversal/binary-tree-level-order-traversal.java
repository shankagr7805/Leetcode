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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return ls;
        q.offer(root);
        while(!q.isEmpty()) {
            int lnum = q.size();
            List<Integer> sub = new LinkedList<Integer>();
            for(int i=0; i<lnum; i++) {
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                sub.add(q.poll().val);
            }
            ls.add(sub);
        }
        return ls;

    }
}