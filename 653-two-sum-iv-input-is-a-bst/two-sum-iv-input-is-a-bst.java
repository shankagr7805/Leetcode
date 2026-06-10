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
    private void in(List<Integer> ans,TreeNode root) {
        if(root == null) return ;
        in(ans, root.left);
        ans.add(root.val);
        in(ans, root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        in(ans, root);
        int l = 0; int r = ans.size()-1;
        while(l<r) {
            int curr = ans.get(l) + ans.get(r);
            if(curr == k) return true;
            else if(curr < k) l++;
            else r--;
        }
        return false;
    }
}