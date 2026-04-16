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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> ls = new LinkedList<List<Integer>>();
        if(root == null) return ls;
        q.offer(root);
        boolean ltr = true;
        while(!q.isEmpty()) {
            int level = q.size();
            List<Integer> sub = new LinkedList<Integer>();
            for(int i=0; i<level; i++) {
                TreeNode node = q.poll();
                if(ltr) sub.addLast(node.val);
                else sub.addFirst(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);   
            }
            ls.add(sub);
            ltr = !ltr;
        }
        return ls;
    }
}