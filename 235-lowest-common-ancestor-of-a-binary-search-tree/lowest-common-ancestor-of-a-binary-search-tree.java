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
    private List<TreeNode> path(TreeNode root, TreeNode x, List<TreeNode> res) {
        res.add(root);
        if(root.val == x.val) {
            return res;
        }
        if(root.val < x.val) { 
            path(root.right, x, res);
        } else {
            path(root.left, x, res);
        }
        return res;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> a = new ArrayList<TreeNode>();
        List<TreeNode> b = new ArrayList<TreeNode>();
        a = path(root, p, a);
        b = path(root, q, b);
        int i=0; int j=0;
        while(i<a.size() && j<b.size()) {
            if(a.get(i).val == b.get(j).val) {
                i++; j++;
            } else {
                break;
            }
        }
        return a.get(i-1);
    }
}