/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_tr, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left != null) {
                parent_tr.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right != null) {
                parent_tr.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_tr = new HashMap<>();
        markParents(root, parent_tr, target);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(target);
        visited.put(target, true);
        int cur = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            if(cur == k) break;
            cur++;
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                if(curr.left!=null && visited.get(curr.left) == null) {
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right!=null && visited.get(curr.right) == null) {
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if(parent_tr.get(curr) != null && visited.get(parent_tr.get(curr))==null) {
                    q.offer(parent_tr.get(curr));
                    visited.put(parent_tr.get(curr), true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode current = q.poll();
            ans.add(current.val);
        }
        return ans;
    }
}